package xhu.wncg.firesystem.system.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xhu.wncg.common.utils.Fire;
import xhu.wncg.common.utils.ShiroUtils;
import xhu.wncg.firesystem.system.pojo.SysUser;
import xhu.wncg.firesystem.system.service.SysUserService;
import xhu.wncg.firesystem.system.service.SysUserTokenService;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/10/24.
 */
@RestController
public class SysLoginController extends AbstractController {
    @Autowired
    private Producer producer;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 获取验证码
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();

        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);


        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        IOUtils.closeQuietly(outputStream);

    }

    /**
     * 系统用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param captcha  验证码
     * @return token
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(String username, String password, String captcha) {
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return Fire.error("验证码不正确！");
        }
        //用户信息
        SysUser user = sysUserService.queryByUsername(username);

        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return Fire.error("账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() == 0) {
            return Fire.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        return sysUserTokenService.createToken(user.getUserId());
    }

    /**
     * 退出登录
     *
     * @return
     */
    @PostMapping("/sys/logout")
    public Fire logout() {
        sysUserTokenService.logout(getUserId());
        return Fire.ok();
    }
}

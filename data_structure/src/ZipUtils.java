import cn.hutool.core.util.ZipUtil;

import java.io.File;

/**
 * @author 郭炳侠
 * @date 2021/8/11
 */
public class ZipUtils {
    public static void main(String[] args) {
        File zip = ZipUtil.zip(args[0], args[1]);
        System.out.println("压缩包目录: " + zip.getPath());
    }

    public static String getPath() {
        String path = ZipUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        if (System.getProperty("os.name").contains("dows")) {
            path = path.substring(1, path.length());
        }
        if (path.contains("jar")) {
            path = path.substring(0, path.lastIndexOf("."));
            return path.substring(0, path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }
}

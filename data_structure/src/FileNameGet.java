import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileNameGet {
    public static void main(String[] args) {
        File[] ls = FileUtil.ls("D:\\gamevedio\\aaa");
        List<String> names = new ArrayList<String>();
        System.out.println(names.size());
        for (File file : ls) {
            names.add(file.getName());
            System.out.println(file.getName());
        }
        List<String> sorted = names.stream().sorted((o1, o2) -> {
            String a = StrUtil.replace(o1, ".webm", "");
            a = StrUtil.replace(a , ".mp4", "");
            String b = StrUtil.replace(o2, ".webm", "");
            b = StrUtil.replace(b, ".mp4", "");

            return Integer.parseInt(a) - Integer.parseInt(b);
            //String s = StrUtil.subAfter(o2, ".webm", true);
        }).collect(Collectors.toList());
        System.out.println(sorted);
    }
}

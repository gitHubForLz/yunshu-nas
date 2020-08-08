package top.itning.yunshu.yunshunas.entity;

public class TEst {
    public static void main(String[] args) {
        String s1="C:/1/23";
        String s2="C:\\1\\23";

        String outDir = s1.replaceAll("/+", Link.SPLIT_REGEX).replaceAll("\\\\+",Link.SPLIT_REGEX);
        String outDir2 = s2.replaceAll("/+", Link.SPLIT_REGEX).replaceAll("\\\\+",Link.SPLIT_REGEX);
        System.out.println(outDir);
        System.out.println(outDir2);
    }
}

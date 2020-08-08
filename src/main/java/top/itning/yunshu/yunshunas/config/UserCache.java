package top.itning.yunshu.yunshunas.config;

import java.util.HashSet;
import java.util.Set;

/**
 * UserCache..
 *
 * @author Lizhong
 * @date 2020/8/4
 */
public class UserCache {

    static Set<String> tokens=new HashSet<>();
    public static boolean  isValid(String token){
        return tokens.contains(token);
    }
    public static void remove(String token){
        tokens.remove(token);
    }
    public static void add(String token){
        tokens.add(token);
    }


}

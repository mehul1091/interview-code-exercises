package org.self.dp.substring;

public class Testcases {

    public static void main(String[] args) {
        System.out.println("Tabulation Runtime");
        allTc(new LongestCommonSubstringDP27Tabulation());
        System.out.println("**********************");
        System.out.println("Recursion Runtime");
        allTc(new LongestCommonSubstringDP27Recursion());
        System.out.println("**********************");
    }

    public static void allTc(LongestCommonSubstringDP27 impl){
        long startTime = System.currentTimeMillis();
        System.out.println("started execution at="+startTime);

        int result = TC("abcjklp", "acjkp", impl);
        if (result != 3) throw new RuntimeException("expected 3");

        result = TC("wasdijkl", "wsdjkl", impl);
        if (result != 3) throw new RuntimeException("expected 3");

        result = TC("abcy", "acby", impl);
        if (result != 1) throw new RuntimeException("expected 1");

        result = TC("tyfg", "cvbnuty", impl);
        if (result != 2) throw new RuntimeException("expected 2");

        result = TC("vpxohx", "ppxmbg", impl);
        if (result != 2) throw new RuntimeException("expected 2");

        result = TC("lvwjh", "fxsus", impl);
        if (result != 0) throw new RuntimeException("expected 0");

        //yqryri uqrybb = 3
        result = TC("yqryri", "uqrybb", impl);
        if (result != 3) throw new RuntimeException("expected 3");

        //htzyl svjal = 1
        result = TC("htzyl", "svjal", impl);
        if (result != 1) throw new RuntimeException("expected 1");

        //jmcay pocad = 2
        result = TC("jmcay", "pocad", impl);
        if (result != 2) throw new RuntimeException("expected 2");

        //guirkc auifpa = 2
        result = TC("guirkc", "auifpa", impl);
        if (result != 2) throw new RuntimeException("expected 2");

        //yqhwuuv vchwuuv = 5
        result = TC("yqhwuuv", "vchwuuv", impl);
        if (result != 5) throw new RuntimeException("expected 5");

        //Very Long Running Test Cases Start from here
        //10
        //upndwajutrgfgjedzz hfcdwcuhlndtalodwj = 2
        result = TC("upndwajutrgfgjedzz", "hfcdwcuhlndtalodwj", impl);
        if (result != 2) throw new RuntimeException("expected 2");

        //fqhztlvjtcxtbwyqtfe smrirxexsuxwteilogk = 1
        result = TC("fqhztlvjtcxtbwyqtfe", "smrirxexsuxwteilogk", impl);
        if (result != 1) throw new RuntimeException("expected 1");

        //nuuesbfxqckukrvdjwi	zvvqibyrpkpwbijdjxo	dj	2
        result = TC("nuuesbfxqckukrvdjwi", "zvvqibyrpkpwbijdjxo", impl);
        if (result != 2) throw new RuntimeException("expected 2");

        //xnbrhenozvgihyvvwc tjrcxuopgjwihyvvei
        //xnbrhenozvgihyvvwc	tjrcxuopgjwihyvvei	ihyvv	5
        result = TC("xnbrhenozvgihyvvwc", "tjrcxuopgjwihyvvei", impl);
        if (result != 5) throw new RuntimeException("expected 5");

        //syqokovkuegxkosnoq mdbjenenuegxkobvnj
        //syqokovkuegxkosnoq	mdbjenenuegxkobvnj	uegxko	6
        result = TC("syqokovkuegxkosnoq", "mdbjenenuegxkobvnj", impl);
        if (result != 6) throw new RuntimeException("expected 6");

        //phvzphmwhhqfltpxcdfh cjerbzicrswwfkpwxlyj
        //phvzphmwhhqfltpxcdfh	cjerbzicrswwfkpwxlyj	p	1
        result = TC("phvzphmwhhqfltpxcdfh", "cjerbzicrswwfkpwxlyj", impl);
        if (result != 1) throw new RuntimeException("expected 1");

        //rkxzfizntzyxixirudqn cexjzuzntzyxixiakrdz
        //rkxzfizntzyxixirudqn	cexjzuzntzyxixiakrdz	zntzyxixi	9
        result = TC("rkxzfizntzyxixirudqn", "cexjzuzntzyxixiakrdz", impl);
        if (result != 9) throw new RuntimeException("expected 9");

        //kzmmvojzenywtefnyz	jnpdvojzenywtefndy	vojzenywtefn	12
        result = TC("kzmmvojzenywtefnyz", "jnpdvojzenywtefndy", impl);
        if (result != 12) throw new RuntimeException("expected 12");


        //mwszrizedfxflpvrwi	jrtmqeichspdlmvmbn	m	1
        result = TC("mwszrizedfxflpvrwi", "jrtmqeichspdlmvmbn", impl);
        if (result != 1) throw new RuntimeException("expected 1");


        //ozocfwykqasyuiheavyu	cdzxyqngeahdfxheavyt	heavy	5
        result = TC("ozocfwykqasyuiheavyu", "cdzxyqngeahdfxheavyt", impl);
        if (result != 5) throw new RuntimeException("expected 5");

        long endTime = System.currentTimeMillis();

        System.out.println("endTime = "+endTime+" execution time= " + (endTime - startTime));
    }

    private static int TC(String s1, String s2, LongestCommonSubstringDP27 impl) {
        return impl.printLengthOfLongestCommonSubstring(s1, s2);
    }
}

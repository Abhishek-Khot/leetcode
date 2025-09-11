class Solution {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder("");
        int n= s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        ArrayList<Character> vowels = new ArrayList<>();
        for(int i= 0;i<n;i++){
            if(set.contains(s.charAt(i))){
                vowels.add(s.charAt(i));
            }
        }
        Collections.sort(vowels);
        int j = 0;
        for(int i = 0;i<n;i++){
            if(set.contains(s.charAt(i))){
                sb.append(vowels.get(j));
                j++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
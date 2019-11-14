import java.util.*;
public class Main{
    public static void main(String[] args){
    }



    /* ������ */
    //1.��������ӣ���������2 ���1+121������3 ���1+121+12321
    private static int addBackNumber(int n){
        if(n==1)
            return 1;
        StringBuilder list=new StringBuilder();
        for(int i=1;i<=n;i++){
            list.append(i);
        }
        for(int i=n-1;i>0;i--){
            list.append(i);
        }
        String s = list.toString();
        int result = Integer.parseInt(s);
        return result+addBackNumber(n-1);
    }
    //2.�ҳ�һ�������е�ż�����
    private static int addEvenNumber(int n){
        char[] chars = String.valueOf(n).toCharArray();
        int sum=0;
        for (char c : chars) {
            if((c-'0')%2==0)
                sum+=c-'0';
        }
        return sum;
    }
    //3.����һ��������ȡ����������е�ż��λ�ϵ��������һ���������������������123456�����246
    private static int createEvenNumber(int n){
        char[] chars = String.valueOf(n).toCharArray();
        StringBuilder sb=new StringBuilder();
        for (char c : chars) {
            if((c-'0')%2==0)
                sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }
    //4.һԪǮ��һƿ��ˮ����������ˮƿ��һƿ��ˮ���������Ǯ���������ܺȶ���ƿ��ˮ
    private static int getNumOfDrink(int money,int bottle){
        bottle = money + bottle;
        if(bottle / 2 == 0) {
            return money;
        }
        return money + getNumOfDrink(bottle / 2 , bottle % 2);
    }
    //5.һԪǮ��һƿ��ˮ����������ˮƿ��һƿ��ˮ������ƿ�ǻ�һƿ��ˮ���������Ǯ���������ܺȶ���ƿ��ˮ
    private static int getNumOfDrink(int money,int bottle,int cap){
        bottle = money + bottle;
        cap=money+cap;
        if(bottle/2+cap/3 == 0) {
            return money;
        }
        return money + getNumOfDrink(bottle / 2+cap/3 , bottle % 2,cap%3);
    }
    //6.�����Լ��
    private static int getGcd(int n1,int n2){
        if(n2==0)
            return n1;
        return getGcd(n2,n1%n2);
    }
    //7.���� n �� b , �ҳ� 1 �� n �б� b �����ĸ���.
    private static int getNumber(int n,int b){
        int count=0;
        for(int i=1;i<=n;i++){
            if(i%b==0)
                count++;
        }
        return count;
    }
    //8.N�Ľ׳�
    private static int getN(int n){
        if(n<=2)
            return n;
        else {
            int[] num = new int[n];
            num[0]=1;
            num[1]=2;
            for(int i=2;i<n;i++){
                num[i]=(i+1)*num[i-1];
            }
            return num[n-1];
        }
    }
    //9.����ʮ����������������һ������������С���͵�һ��������
    private static int[] numberChange(int[] array){
        int minIndex=0;
        int min=array[0];
        int maxIndex=0;
        int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]<min){
                min=array[i];
                minIndex=i;
            }
            if(array[i]>max){
                max=array[i];
                maxIndex=i;
            }
        }
        int temp1=array[0];
        array[0]=min;
        array[minIndex]=temp1;
        int temp2=array[array.length-1];
        array[array.length-1]=max;
        array[maxIndex]=temp2;
        return array;
    }
    //10.���������������
    private static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        int total=array[0];
        int maxSum=array[0];
        for(int i=1;i<array.length;i++){
            total=(total>0)?total+array[i]:array[i];
            maxSum= Math.max(maxSum, total);
        }
        return maxSum;
    }
    //11.���������ҳ�Ψһ����һ�ε���
    private static int findOnlyNum(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : arr) {
            if(!map.containsKey(number))
                map.put(number,1);
            else {
                int val = map.get(number);
                map.replace(number,val,val+1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            if(map.get(integer)==1)
                return integer;
        }
        return -1;
    }
    //12.Լɪ�򻷣����������ͼ���������˳��
    private static void Josephus(int num,int k){
        //�±��1��ʼ
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=num;i++){
            list.add(i);
        }
        int target=0;
        while (!list.isEmpty()){
            target=(target+k-1)%list.size();
            if(target!=0){
                System.out.println(list.get(target)+"������");
                list.remove(target);
            }
            else {
                System.out.println(list.get(list.size()-1)+"������");
                list.remove(list.size()-1);
            }
        }
    }
    //13.��һ��8Ԫ����������1 3 0 3 6 0 0 9������0�ź��棬��������˳�򲻱䣬���Ϊ1 3 3 6 9 0 0 0
    private static int[] removeZero(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i : arr) {
            if(i!=0)
                list.add(i);
        }
        //����0
        int[] result=new int[8];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    /* �ж��� */
    //1.�ж�����,����ֻ��1���Լ�
    private static boolean isPrimeNumber(int n){
        if(n==1)
            return false;
        if(n==2)
            return true;
        for(int i=2;i<n/2+1;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    //2.�����������֮����������
    private static void printYear(int y1, int y2){
        for(int i=y1;i<=y2;i++){
            if(i%400==0||(i%4==0&&i%100!=0))
                System.out.print(i+",");
        }
    }
    //3.���������գ����������ĵڼ���
    private static int getDaynumberOfYear(int year,int month,int day){
        boolean isYear=false;
        if(year%400==0||(year%4==0&&year%100!=0))
            isYear=true;
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        if(isYear)
            days[1]=29;
        int sum=0;
        for(int i=0;i<month-1;i++){
            sum+=days[i];
        }
        sum+=day;
        return sum;

    }
    //4.��һ����������̨�ף����� 1 <= n < 90 ������Ϊ̨������������ 0 ��Ϊ������־�����n��̨�׹��ж�������¥��ʽ
    private static int numOfFloor(int n){
        if(n<=2)
            return n;
        else {
            int[] num=new int[n];
            num[0]=1;
            num[1]=2;
            for(int i=2;i<n;i++){
                num[i]=num[i-1]+num[i-2];
            }
            return num[n-1];
        }
    }
    //5.һֻС����һ��ժ��������ӣ���һ�����һ�룬Ȼ���̲�ס�ֳ���һ�����ڶ����ֳ���һ�룬�ټ���һ��������ÿ�춼�������ԡ�
    // ����10���ʱ��С���ӷ���ֻ��һ�������ˡ���С���ӵ�һ�칲ժ�˶��ٸ�����
    private static int NumOfPeach(){
        int left=1;
        for(int i=1;i<10;i++){
            left=(left+1)*2;
        }
        return left;
    }
    //6.��������abc���ܷ���1000-9999֮���ҵ�һ����x������x%a=0�ң�x+1��%b=0�ң�x+2��%c=0���Ҳ��������x�ͷ���Impossible
    private static String findNumber(int a, int b, int c){
        for(int i=1000;i<9999;i++){
            if((i%a==0)&&((i+1)%b==0)&&((i+2)%c==0)) {
                return "can";
            }
        }
       return"Impossible";
    }
    //7.�ж������ַ����Ƿ�����λ
    private static boolean isDifferentPosition(String s1,String s2){
        char[] array1 = s1.toCharArray();
        char[] array2= s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if(array1[i]!=array2[i])
                return false;
        }
        return true;
    }

    /* �ַ����� */
    //1.����һ��ֻ������ĸ���ַ��������ַ����еĴ�д��ĸ��ΪСд��ĸ����Сд��ĸ��Ϊ��д��ĸ�������
    private static String changeStr(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if('a'<=c[i]&&c[i]<='z') {
                System.out.println("Сд����д");
                c[i] = (char)(c[i]-32);
                continue;
            }
            if('A'<=c[i]&&c[i]<='Z')
                System.out.println("��д��Сд");
                c[i]=(char)(c[i]+32);
        }
        return  String.valueOf(c);
    }
    //2.�ַ�������,���ַ����е��ַ�a��A����c�����
    public static String toSecret(String s){
        char[] chars = s.toCharArray();
        StringBuilder re= new StringBuilder();
        for (char aChar : chars) {
            if(aChar=='a'||aChar=='A')
                re.append('c');
            else
                re.append(aChar);
        }
        return re.toString();
    }
    //3.�ַ�����ת
    public static String reverse(String s){
        char[] chars = s.toCharArray();
        StringBuilder re= new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            re.append(chars[i]);
        }
        return re.toString();
    }
    //4.�����ǰ׺ leetcode14
    private static String longestSameStr(String[] strs){
        if(strs.length==0)
            return "";
        String s=strs[0];
        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(s)!=0){
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
    //5.���뼸�����ʣ�����ĸ�任������һ�鵥������������ĸ�ǵ�i������任�����ĸ��26-i+1��
    private static String changeStr2(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if('a'<=c[i]&&c[i]<='z') {
                c[i] = (char)('a'*2+25-c[i]);
            }
            if('A'<=c[i]&&c[i]<='Z')
            c[i]=(char)('A'*2+25-c[i]);
        }
        return  String.valueOf(c);
    }
    //6.A,B�����ַ���,���ڵ�һ���ַ�������,�ڶ����ַ�����δ���ֵ�,�ظ�ֻȡ��һ�γ���,����ַ���
    private static String getStrOfStrings(String s1,String s2){
        //����һ���ַ����в��ظ��Ĵ���char����
        ArrayList<Character> chars=new ArrayList<>();
        char[] c1 = s1.toCharArray();
        for (char c : c1) {
            if(!chars.contains(c))
                chars.add(c);
        }
        System.out.println(chars.toString());
        //���ڶ����ַ�������chars2����
        ArrayList<Character> chars2=new ArrayList<>();
        char[] c2 = s2.toCharArray();
        for (char c : c2) {
                chars2.add(c);
        }
        System.out.println(chars2.toString());
        //����������������
        StringBuilder sb=new StringBuilder();
        for (Character character : chars) {
            if(!chars2.contains(character))
                sb.append(character);
        }
        return sb.toString();
    }
    //7.����ַ����ļ�ƣ������ַ�����"end of file"�����"EOF"
    private static String getSimpleStr(String s){
        String[] s1 = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String s2 : s1) {
            char[] chars = s2.toCharArray();
            char aChar = chars[0];
            sb.append(aChar);
        }
        String result = sb.toString().toUpperCase();
        return result;
    }

    /* ������ */
    //1.������������M��N,���������ת��Ϊ������λ��ͬ�ĸ���
    private static int differentNumOf2Number(int m,int n){
        //��� ��ͬΪ1 ��ͬΪ0 ��ͳ��1�ĸ���
        int i = m^n;
        int count=0;
        char[] c = Integer.toBinaryString(i).toCharArray();
        for(int j=0;j<c.length;j++){
            if(c[j]=='1')
                count++;
        }
        return count;
    }
    //2.10����ת��k����
    public static String getBNumber(int n,int k){
        ArrayList<Integer> list=new ArrayList();
        int n1=n;
        StringBuilder re= new StringBuilder();
        while(n1!=0){
            list.add(n1%k);
            n1/=k;
        }
        Object[] array = list.toArray();
        for(int i=array.length-1;i>=0;i--){
            re.append(array[i]);
        }
        System.out.println(n+"��"+k+"������ʽΪ��"+re);
        return re.toString();
    }
    //3.k����ת��10����
    public static void getTNumber(String s,int k){
        char[] chars = s.toCharArray();
        int n=0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i]=='1')
                n+=Math.pow(k,chars.length-i-1);
        }
        System.out.println(s+"��ʮ������ʽΪ��"+n);
    }


}


```java
@RestController
public class WebController {


    @PostMapping(value = "float")
    public float calcu( float x , float y) {
        float z;
        float ans;
        DecimalFormat df = new DecimalFormat("##.00");
        z = x * y;

        ans = (float) Double.parseDouble(df.format(z));

        return ans;


    }


@PostMapping(value = "identify")
    public String id(@RequestBody IdentifyRequest request) {
                     //註解        //參數
        int age;
        age = 2020 - request.getBirth();


        int animal = request.getBirth() % 12;

        String result = Test.getName(animal);


Map<Integer,String> hashmap = new HashMap<>();

        hashmap.put(0 , "猴年");
        hashmap.put(1 , "雞年");
        hashmap.put(2 , "狗年");
        hashmap.put(3 , "豬年");
        hashmap.put(4 , "鼠年");
        hashmap.put(5 , "牛年");
        hashmap.put(6 , "虎年");
        hashmap.put(7 , "兔年");
        hashmap.put(8 , "龍年");
        hashmap.put(9 , "蛇年");
        hashmap.put(10 , "馬年");
        hashmap.put(11 , "羊年");
        result=hashmap.get(animal);
        List<String> animalList= new ArrayList<>();
        animalList.add("猴年");
        animalList.add("雞年");



        //return ("這人名字是 : " + request.getName() + "今年" + age + "歲. 他是" + animalList + "寶寶");
        
        return ("name: " + request.getName() + "\nbirth : " + request.getBirth() + "\nage : " + age + "\nAnimal: "+result);
    }
}
import java.util.Scanner;
public class App { 
    static String names[]={ "Ahmedtamer", "Marawantarek"," Mirnatarek", "Rodainawaleed", "Mariamkhaled"," mostafamohamed"};
static String phonenumbers[]={"01222277777",
 "01211111118",
 "01223344556",
 "01255555666",
 "01288998899",
 "01200050006"};
 static String emails[]={"ahmed@gmail.com",
 "marawan@gmail.com",
 "mirna@gmail.com",
 "rodaina@gmail.com",
 "mariam@gmail.com",
 "mostafa@gmail.com"
 };
 static int id[]={1,2,3,4,5,6};
 static long balance[]={5000,3000,8000,7000,6000,2000};
 static String[] history=new String[50];
 static String[]favourits=new String[5];
static int favcounter=0;
static int historycounter=0;
static int loggedyuserindex;
 static void login(){
    Scanner input= new Scanner(System.in);
 loggedyuserindex=0;
 System.out.println("Enter your id:");
 int identered=input.nextInt();
 System.out.println("your id:"+identered);
 boolean found=false;
 for(int i=0;i<id.length;i++){
if(identered==id[i]){
    loggedyuserindex=i;
    System.out.println("login sucessful");
    found=true;
    break;
}
 }
if(found==false)  {
    System.out.println("login faild,please enter the correct id");//keda hqy3,el log in aw laa
}
 }
 static void showbalance(){
    System.out.println("your current balance is:"+balance[loggedyuserindex]);
 }

 static void transfermoney(){
Scanner input=new Scanner(System.in);
System.out.println("Please Enter the email of the recipient:");
String email=input.next();  //add @ value
int recipientindex=-1;
boolean emailfound=false;
for(int i=0;i<emails.length;i++){
    if(email.equals(emails[i])){
        recipientindex=i;
    emailfound=true;
    System.out.println("correct email!");
    break;
    }
}
 if(emailfound==false){
 System.out.println("Sorry the email is not correct" );
 System.out.println("please enter the correct email of the recipient");
 }
 System.out.println("Now Please enter the amount to be transferred:");
 long amounttobetransfered=input.nextLong();
while(amounttobetransfered>balance[recipientindex]){
 System.out.println("Transfering failed!!, your balance is not enough to complite the transferring");
 System.out.println("please enter a valid amount");
 amounttobetransfered=input.nextLong();
}
if(amounttobetransfered<=balance[recipientindex]){
System.out.println("Transfering sucssed");
historycounter++;
balance[recipientindex]+=amounttobetransfered;
balance[loggedyuserindex]-=amounttobetransfered;
System.out.println("Your balance now is:"+balance[loggedyuserindex]);
}
 }
static void transferhistory(){
    System.out.println("==========Transfer history=========");
for(int i=0;i<historycounter;i++){
System.out.println("Your history="+ history[i]);
}
}
   
static void addfavorite(){
Scanner input= new Scanner(System.in);
System.out.println("Please enter the email of the user you want to add to your fav list:");
System.out.println("please check that your email contains @");
boolean Contains=false;
String email = input.next();
int favindex=-1;
for(int i=0;i<emails.length;i++){
    if(email.equals(emails[i])){
   if(email.contains("@")){
     Contains=true;
     break;
   }if(Contains==false){
    System.out.println("Your email is uncorrect,Please check it again");

   }
    favourits[favcounter]=emails[i];
        favindex=i;
        favcounter++;
System.out.println("Favourits:"+emails[i]);
System.out.println("num of fav accounts="+favcounter);
    }
}

}
static void removefavourits(){
Scanner input =new Scanner(System.in);
System.out.println("Enter the email of the user you want to remove from your fav liste:");
String email =input.next();
int removefavindex=-1;
for(int i=0;i<favcounter;i++){
    if(email.equals(favourits[i])){
        removefavindex=i;
        break;
    }
    if(removefavindex!=-1){
        for(i=removefavindex;i<favcounter-1;i--){
            favourits[i]=favourits[i+1];
        }
        favcounter--;
    System.out.println("Removed successfully");
    }else{
        System.out.println("Email not found");
    }
}
}

static void showfavouritelist(){
System.out.println("===============Your favourite Liste===============");
if(favcounter!=0){
    for(int i=0;i<favcounter;i++){
    System.out.println(favourits[i]);
    } 
}else{
    System.out.println("your fav list is empty!!!");
}
}
static void searchrecipient(){
Scanner input =new Scanner(System.in);
System.out.println("Please enter the email of the recipient you want to search for:");
String email = input.next();
int recipientindex=0;
    boolean recipientemailfound=false;
for(int i=0;i<emails.length;i++){
    recipientindex=i;
if(email.equals(emails[recipientindex])){
    boolean recipienteailfound=true;
    System.out.println("The recipient info are:");
    System.out.println("Full name:"+names[recipientindex]);
    System.out.println("Phone number:"+phonenumbers[recipientindex]);
    System.out.println("id:"+id[recipientindex]);
}
}
if(recipientemailfound=false){
    System.out.println("Email not found");

}
}
static void viewprofile(){
System.out.println("===============View Profile===============");
System.out.println("Name:"+names[loggedyuserindex] );
System.out.println("Phone number:"+phonenumbers[loggedyuserindex]);
System.out.println("Email:"+emails[loggedyuserindex]);
System.out.println("ID:"+id[loggedyuserindex]);
System.out.println("Current balance:"+balance[loggedyuserindex]);
}
 

static void updateprofile(){
Scanner input =new Scanner(System.in);
    System.out.println("Please enter your new name:");
    names[loggedyuserindex]=input.next();
    System.out.println("Please enter your new phone num:");
    phonenumbers[loggedyuserindex]=input.next();
    System.out.println("Please enter your new email:");
    emails[loggedyuserindex]=input.next();
}



static void logout(){
loggedyuserindex=-1;
System.out.println("You logged out successfully");

}
}

 

 
 



    public static void main(String[] args) {

     
    } 
// static Arraylist<strinr>    =new List<>();
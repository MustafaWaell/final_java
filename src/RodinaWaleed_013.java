import java.util.Scanner;

public class RodinaWaleed_013 {
    //================= User panel==================
    /* اول method عندي هي ال show statistics في الجزء ده هنعرف عدد المستخدمين اللي معانا
    كام واحد منهم active وكام blocked وكل عمليات التحويل سواء نجحت او فشلت و اجمالي مبالغ التحويل الناجحة
    */
    static void showStatistics(String accountStatuses[], boolean transactionStatuses[]) {
        int totalUsers = accountStatuses.length;
        int activeUsers = 0;
        int blockedUsers = 0;
        for (int m = 0; m < accountStatuses.length; m++) {
            if (accountStatuses[m].equalsIgnoreCase("Active")) {
                activeUsers++;
            } else if (accountStatuses[m].equalsIgnoreCase("Blocked")) {
                blockedUsers++;
            }

        }
        int totalTransactions = transactionStatuses.length;
        int successfulTransactions = 0;
        int failedTransactions = 0;
        long totalSuccessfulAmount = 0;
        for (int z = 0; z < transactionStatuses.length; z++) {
            if (transactionStatuses[z] == true) {
                successfulTransactions++;

            } else {
                failedTransactions++;
            }
        }
        System.out.println("===============ADMIN STATISTICS===============");
        System.out.println("Total Registered Users: " + totalUsers);
        System.out.println("Active Users: " + activeUsers);
        System.out.println("Blocked Users: " + blockedUsers);
        System.out.println("Total Transactions: " + totalTransactions);
        System.out.println("Successful Transactions: " + successfulTransactions);
        System.out.println("Failed Transactions: " + failedTransactions);
    }

    //================================================================================================================
        /*
ال method دي بتمكن ال Admin يدور على user عن طريق أنه بيكتب اي كلمة مفتاحية سواءID اوname اوغيره
 انا حطاها "key founder"
 ولو فعلا الكلمة المفتاحية دي موجودة وده هيبقى عند ميرنا اول ما نلاقي الكلمة دي نطبع بيانات المستخدم
  ولو ملقناهاش تظهر رسالة أن ال user ده مش موجود
         */
    static void SearchUser(String KeyFounder, String userIds[], String names[], String emails[], String phones[], long balance[], String statuses[]) {
        boolean founder = false;
        for (int t = 0; t < userIds.length; t++) {
            if (userIds[t].equalsIgnoreCase(KeyFounder) ||
                    names[t].equalsIgnoreCase(KeyFounder) ||
                    emails[t].equalsIgnoreCase(KeyFounder) ||
                    phones[t].equalsIgnoreCase(KeyFounder)) {
                System.out.println("===============USER FOUND===============");
                System.out.println("User ID: " + userIds[t]);
                System.out.println("Full name: " + names[t]);
                System.out.println("Emails: " + emails[t]);
                System.out.println("Phones: " + phones[t]);
                System.out.println("Balance: " + balance[t]);
                System.out.println("statuses: " + statuses[t]);
                System.out.println("==========================================");
                founder = true;
                break;
            }
            if (founder == false) {
                System.out.println("User not found with search key; " + KeyFounder);
            }

        }
    }

    //==================================================================================================================
   /*
   ال method دي بتوري ال admin كل المستخدمين الموجودين في ال system مرة واحدة
   عملت for loop بتلف على كل عناصر ال array عشان نقدر نطبع كل التفاصيل للمستخدم الواحد
    */
    static void viewAllUsers(String usersId[], String fullName[], String emailAddress[], String phoneNumber[], long currentBalance[], String AccountStatus[]) {
        System.out.println("===============All Registered Users===============");
        for (int h = 0; h < usersId.length; h++) {
            System.out.println("User Number: " + (h + 1));
            System.out.println("User ID: " + usersId[h]);
            System.out.println("Full Name: " + fullName[h]);
            System.out.println("Email Address: " + emailAddress[h]);
            System.out.println("Phone Number: " + phoneNumber[h]);
            System.out.println("Current Balance: " + currentBalance[h]);
            System.out.println("Account Status" + AccountStatus[h]);
            System.out.println("==========================================");
        }
    }

    //==================================================================================================================
    /*
         ال method دي بتخلي ال Admin يغير اي حاجة هو عايزها في user account
عن طريق إن هي بتدور على ID معين "target ID" عندي فالكود
وبتتأكد من صحة بيانات زي مثلا أن email يبقى فيه @
         وتحدث البيانات القديمة بالقيم الجديدة في نفس مكان ال index جوا ال array
     */
    static void updateUser(String targetID, String NewName, String NewEmailAddress, String NewPhone, String NewCurrentBalance, String NewAccountStatus, String userIds[], String names[], String emails[], String phones[], long balance[], String statuses[]) {
        boolean fond = false;
        for (int q = 0; q < userIds.length; q++) {
            if (userIds[q].equalsIgnoreCase(targetID)) {
                if (NewEmailAddress.contains("@")) {
                    names[q] = NewName;
                    emails[q] = NewEmailAddress;
                    phones[q] = NewPhone;
                    System.out.println("===============User Updated Successfully ===============");
                    System.out.println("User ID: " + userIds[q]);
                    System.out.println("New Name: " + names[q]);
                    System.out.println("New Email: " + emails[q]);
                    System.out.println("New Plone: " + phones[q]);
                    System.out.println("============================================================ ");
                } else {
                    System.out.println("Error: invalid email address!!  update failed");
                }
                fond = true;
                break;
            }
        }
        if (fond == false) {
            System.out.println("User not found with ID: " + targetID);
        }
    }
    //==================================================================================================================
   /*
   ال method دي بتظهر المعاملات المادية اللي جوا النظام
ال for loop هتلف على كل ال parameters اللي جواه الميثود
وبعدين تبدأ تطبع كل التفاصيل
    */
    static void ShowTransactionHistory(String TransactionsIDs[], String senders[], String receivers[], long Amounts[], boolean TransactionStatus[]) {
        System.out.println("===============All Transactions History===============");
        for (int l = 0; l < TransactionsIDs.length; l++) {
            String Status = " ";
            if (TransactionStatus[l] == true) {
                Status = "Success";
            } else {
                Status = "Failed";
            }
            System.out.println("Transaction Number: " + (l + 1));
            System.out.println("Transaction ID: " + TransactionsIDs[l]);
            System.out.println("Sender: " + senders[l]);
            System.out.println("Receiver: " + receivers[l]);
            System.out.println("Amount: " + Amounts[l]);
            System.out.println("Statue: " + TransactionStatus[l]);
            System.out.println("========================================================");
        }
    }
        //==========================================================================================================
  /*
  ال method دي بتخلي ال Admin يمنع ال user من أنه يدخل ال system أو من الاخر بتخليه blocked
انا اي حاجة بدور عليها مثبتة ال targed id دايما
واول ما تلاقي ال target ID بتحول حالة المستخدم ده من active ل blocked
   */
    public static void blockAccounts(String targetD, String userIds[], String statuses[]){
       boolean SearchingForID=false;
        for (int r = 0; r< userIds.length; r++){
            if (userIds[r].equalsIgnoreCase(targetD)) {
                statuses[r]="Blocked";
                System.out.println("User Account"+ targetD +"has been blocked successfully ");
                SearchingForID=true;
                break;
            }
            if (SearchingForID==false){
                System.out.println("User not found with ID: "+ targetD);
            }
        }
    }
    //==========================================================================================================
   /*
   المرة دي بقا هرجع ال user اللي بلكته ده ونخليه active تاني
   برده بندور بال target ID
   اول ما نلاقيه ترجع إلى user تاني active
   ملحوظة بس عشان لو حد فيكوا مش فاهم ايه ال target id ده :
ده رقم متخزن عند ميرنا عادي هنختار اللي احنا عايزنه وندور بيه على باقي تفاصيل المستخدم
    */
    static void unblockAccount(String targetID, String userIds[], String statuses[]){
        boolean findID=false;
        for (int w = 0; w< userIds.length; w++){
            if (userIds[w].equalsIgnoreCase(targetID)){
                statuses[w]="Active";
                System.out.println("User Account: "+ targetID +"has been Unblocked and active now");
                findID=true;
                break;
            }
            if (findID==false){
                System.out.println("User not found with ID: "+ targetID);
            }
        }
    }
    //==========================================================================================================
   /*
   اخر method عندي بتعرض لل admin كل حاجة تخص مستخدم واحد
برده هنطلب من ال admin يدخل target ID اللي هو عايزه مش شرط رقم معين اهم حاجة متخزن عند ميرنا
اول ما يدخله لو صح فعلا يطبع كل حاجة تخص ال user ده
    */
    public static void viewUserDetails(String targetId, String[] userIds, String[] names, String[] emails, String[] phones, long[] balances, String[] statuses) {

        boolean findingUser = false;
        for (int o = 0; o < userIds.length; o++) {

            if (userIds[o].equalsIgnoreCase(targetId)) {
                System.out.println("========== USER DETAILED INFORMATION ==========");
                System.out.println("User ID: " + userIds[o]);
                System.out.println("Full Name: " + names[o]);
                System.out.println("Email Address: " + emails[o]);
                System.out.println("Phone Number: " + phones[o]);
                System.out.println("Current Balance: " + balances[o] );
                System.out.println("Account Status: " + statuses[o]);
                System.out.println("===============================================");
                findingUser = true;
                break;
            }
        }
        if (findingUser == false) {
            System.out.println("Error: User with ID " + targetId + " does not exist!!");
        }
    }
    //==========================================================================================================
public static void main(String[] args){
    Scanner input= new Scanner(System.in);
}
    }


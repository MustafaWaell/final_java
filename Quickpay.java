import java.util.Scanner;

public class Quickpay {

    static Scanner input = new Scanner(System.in);

    // user data storage

    static String[] names = {"Ahmedtamer", "Marawantarek", "Mirnatarek",
            "Rodainawaleed", "Mariamkhaled", "mostafamohamed"
    };

    static String[] phonenumbers = {"01222277177", "01211111118", "01223344556",
            "01255555666", "01288998899", "01200050006"
    };

    static String[] emails = {
            "ahmed@gmail.com",
            "marawan@gmail.com",
            "mirna@gmail.com",
            "rodaina@gmail.com",
            "mariam@gmail.com",
            "mostafa@gmail.com"
    };

    static String[] userIds = {"1", "2", "3", "4", "5", "6"};

    static long[] balance = {1000, 3000, 8000, 7000, 6000, 2000};

    static final int num_users = 6;
    static final int max_trans = 100;

    static String[] accountStatuses = {
            "ACTIVE", "ACTIVE", "ACTIVE",
            "ACTIVE", "BLOCKED", "ACTIVE"
    };

    // transaction data

    static int[] transactionIds = new int[max_trans];
    static int[] transactionSenders = new int[max_trans];
    static int[] transactionReceivers = new int[max_trans];
    static long[] transactionAmounts = new long[max_trans];
    static boolean[] transactionStatuses = new boolean[max_trans];

    static int transactionCount = 0;

    //  FAVORITE CONTACTS

    static int[][] favoriteContacts =
            new int[num_users][num_users - 1];

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
        int successfulTransactions = 0;
        int failedTransactions = 0;
        for (int z = 0; z < transactionCount; z++) {
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
        System.out.println("Total Transactions: " + (successfulTransactions + failedTransactions));
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
        }
        if (founder == false) {
            System.out.println("User not found with search key; " + KeyFounder);
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
            System.out.println("Account Status: " + AccountStatus[h]);
            System.out.println("==========================================");
        }
    }

    //==================================================================================================================

//        ال method دي بتخلي ال Admin يغير اي حاجة هو عايزها في user account
//عن طريق إن هي بتدور على ID معين "target ID" عندي فالكود
//وبتتأكد من صحة بيانات زي مثلا أن email يبقى فيه @
//         وتحدث البيانات القديمة بالقيم الجديدة في نفس مكان ال index جوا ال array

    static void updateUser(String targetID, String NewName, String NewEmailAddress, String NewPhone, String userIds[], String names[], String emails[], String phones[], long balance[], String statuses[]) {
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
    static void ShowTransactionHistory(int TransactionsIDs[], int senders[], int  receivers[], long Amounts[], boolean TransactionStatus[]) {
        System.out.println("===============All Transactions History===============");
        for (int l = 0; l < transactionCount; l++) {
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
            System.out.println("Statue: " + (TransactionStatus[l] ? "Success" : "Failed"));
            System.out.println("========================================================");
        }
    }

    //==========================================================================================================
  /*
  ال method دي بتخلي ال Admin يمنع ال user من أنه يدخل ال system أو من الاخر بتخليه blocked
انا اي حاجة بدور عليها مثبتة ال targed id دايما
واول ما تلاقي ال target ID بتحول حالة المستخدم ده من active ل blocked
   */
    public static void blockAccounts(String targetD, String userIds[], String statuses[]) {
        boolean SearchingForID = false;
        for (int r = 0; r < userIds.length; r++) {
            if (userIds[r].equalsIgnoreCase(targetD)) {
                statuses[r] = "Blocked";
                System.out.println("User Account" + targetD + "has been blocked successfully ");
                SearchingForID = true;
                break;
            }
        }
        if (SearchingForID == false) {
            System.out.println("User not found with ID: " + targetD);

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
    static void unblockAccount(String targetID, String userIds[], String statuses[]) {
        boolean findID = false;
        for (int w = 0; w < userIds.length; w++) {
            if (userIds[w].equalsIgnoreCase(targetID)) {
                statuses[w] = "Active";
                System.out.println("User Account: " + targetID + "has been Unblocked and active now");
                findID = true;
                break;
            }

        }
        if (findID == false) {
            System.out.println("User not found with ID: " + targetID);
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
                System.out.println("Current Balance: " + balances[o]);
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
    static String[] history = new String[50];
    static String[] favourits = new String[5];
    static int favcounter = 0;
    static int historycounter = 0;
    static int loggedyuserindex;

    static void login() {
        loggedyuserindex = -1;
        System.out.println("Enter your id:");
        String idEntered = input.nextLine();
        System.out.println("your id:" + idEntered);
        boolean found = false;
        for (int i = 0; i < userIds.length; i++) {
            if (idEntered.equalsIgnoreCase(userIds[i])) {
                loggedyuserindex = i;
                System.out.println("login successful");
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("login faild,please enter the correct id");//keda hqy3,el log in aw laa
        }
    }

    static void showbalance() {
        System.out.println("your current balance is:" + balance[loggedyuserindex]);
    }

    static void transferMoney() {
//        هناخد بيانات اللي هيبعت
       int senderIndex=loggedyuserindex;

//        هنشوف لو اللي بيبعت valid
        if (senderIndex == -1 || senderIndex >= emails.length || senderIndex >= balance.length || senderIndex >= accountStatuses.length) {
            System.out.println("Invalid sender");
            return;
        }
//هنشوف اللي بيبعت الاكونت بتاعه اكتف ولا لا
        if (accountStatuses[senderIndex].equalsIgnoreCase("BLOCKED")) {
            System.out.println("Sender's account is blocked");
            return;
        }
//        ناخد ايميل المستلم ونتاكد منه
        System.out.println("Please Enter the email of the recipient:");
        String email = input.nextLine();  //add @ value
        int recipientindex = -1;
        for (int i = 0; i < emails.length; i++) {
            if (email.equals(emails[i])) {
                recipientindex = i;
                System.out.println("correct email!");
                break;
            }
        }
        if (recipientindex == -1) {
            System.out.println("Recipient not found");
            return;
        }
        if (recipientindex >= balance.length || recipientindex >= accountStatuses.length || recipientindex >= userIds.length) {
            System.out.println("Invalid recipient");
            return;
        }

// اللي هيبعت واللي هيستلم مش نفس الشخص

        if (senderIndex == recipientindex) {
            System.out.println("Cannot transfer to yourself");
            return;
        }
        if (accountStatuses[recipientindex].equalsIgnoreCase("BLOCKED")) {
            System.out.println("Recipient account is blocked");
            return;
        }
//        مبلغ التحويل

        System.out.println("Now Please enter the amount to be transferred:");
        long amounttobetransfered = input.nextLong();
        if (amounttobetransfered <= 0) {
            System.out.println("Amount must ne greater than zero");
            return;
        }
//       هنشوف جيب اللي بيبعت مليان ولا فاضي

        if (amounttobetransfered > balance[senderIndex]) {
            System.out.println("No enough balance");
            return;
        }if (transactionCount >= max_trans) {
            System.out.println("Transaction history is full");
            return;
        }
//        هنتاكد ان في مكان للتخزين ونغير الرصيد

        balance[senderIndex] -= amounttobetransfered;
        balance[recipientindex] += amounttobetransfered;
        if (transactionCount < max_trans) {
            transactionIds[transactionCount] = transactionCount + 1;
            transactionSenders[transactionCount] = senderIndex;
            transactionReceivers[transactionCount] = recipientindex;
            transactionAmounts[transactionCount] = amounttobetransfered;
            transactionStatuses[transactionCount] = true;
            transactionCount++;
        }
        System.out.println("transfer successful!");
        System.out.println("Sender's new balance: " + balance[senderIndex] + "piastres");
        System.out.println("Recipient's new balance: " + balance[recipientindex] + "piastres");
    }

    static void transferhistory() {
        System.out.println("==========Transfer history=========");
        boolean found=false;
        for (int i = 0; i <transactionCount ; i++) {
            if (transactionSenders[i] == loggedyuserindex ||
                    transactionReceivers[i] == loggedyuserindex) {
                System.out.println("Transaction ID: " + transactionIds[i]);
                System.out.println("Amount: " + transactionAmounts[i]);
                System.out.println("Status: " +
                        (transactionStatuses[i] ? "Success" : "Failed"));
                System.out.println("=============================");
                found=true;
            }
            }
        if(found=false){
            System.out.println("No transactions found");
        }
    }

    static void addfavorite() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the email of the user you want to add to your fav list:");
        System.out.println("please check that your email contains @");
        boolean Contains = false;
        String email = input.next();
        int favindex = -1;
        for (int i = 0; i < emails.length; i++) {
            if (email.equals(emails[i])) {
                if (email.contains("@")) {
                    Contains = true;
                    favourits[favcounter] = emails[i];
                    favindex = i;
                    favcounter++;
                    System.out.println("Favourits:" + emails[i]);
                    System.out.println("num of fav accounts=" + favcounter);
                    break;
                }
                if (Contains == false) {
                    System.out.println("Your email is uncorrect,Please check it again");

                }
                favourits[favcounter] = emails[i];
                favindex = i;
                favcounter++;
                System.out.println("Favourits:" + emails[i]);
                System.out.println("num of fav accounts=" + favcounter);
            }
        }

    }

    static void removefavourits() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the email of the user you want to remove from your fav liste:");
        String email = input.next();
        int removefavindex = -1;
        for (int i = 0; i < favcounter; i++) {
            if (email.equals(favourits[i])) {
                removefavindex = i;
                break;
            }
            if (removefavindex != -1) {
                for (i = removefavindex; i < favcounter - 1; i++) {
                    favourits[i] = favourits[i + 1];
                }
                favcounter--;
                System.out.println("Removed successfully");
            } else {
                System.out.println("Email not found");
            }
        }
    }

    static void showfavouritelist() {
        System.out.println("===============Your favourite Liste===============");
        if (favcounter != 0) {
            for (int i = 0; i < favcounter; i++) {
                System.out.println(favourits[i]);
            }
        } else {
            System.out.println("your fav list is empty!!!");
        }
    }

    static void searchrecipient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the email of the recipient you want to search for:");
        String email = input.next();
        int recipientindex = 0;
        boolean recipientemailfound = false;
        for (int i = 0; i < emails.length; i++) {
            recipientindex = i;
            if (email.equals(emails[recipientindex])) {
                boolean recipienteailfound = true;
                System.out.println("The recipient info are:");
                System.out.println("Full name:" + names[recipientindex]);
                System.out.println("Phone number:" + phonenumbers[recipientindex]);
                System.out.println("id:" + userIds[recipientindex]);
            }
        }
        if (recipientemailfound = false) {
            System.out.println("Email not found");

        }
    }

    static void viewprofile() {
        System.out.println("===============View Profile===============");
        System.out.println("Name:" + names[loggedyuserindex]);
        System.out.println("Phone number:" + phonenumbers[loggedyuserindex]);
        System.out.println("Email:" + emails[loggedyuserindex]);
        System.out.println("ID:" + userIds[loggedyuserindex]);
        System.out.println("Current balance:" + balance[loggedyuserindex]);
    }


    static void updateprofile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your new name:");
        names[loggedyuserindex] = input.nextLine();
        System.out.println("Please enter your new phone num:");
        phonenumbers[loggedyuserindex] = input.next();
        System.out.println("Please enter your new email:");
        emails[loggedyuserindex] = input.next();
    }


    static void logout() {
        loggedyuserindex = -1;
        System.out.println("You logged out successfully");

    }


    public static void main(String[] args) {
        int choice;
        int userChoice;
        do {
            System.out.println("==========MAIN MENU===========");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
//     الnextline عشان تقرا ال\n
            switch (choice) {
                case 1:
                    int adminChoice;
                    do {
                        System.out.println("=========== Admin Menu=========");
                        System.out.println("1. View All Users");
                        System.out.println("2.Search Users ");
                        System.out.println("3.View Users Details");
                        System.out.println("4.Update User");
                        System.out.println("5. Block Account");
                        System.out.println("6. Unblock Account");
                        System.out.println("7. Show Statistics");
                        System.out.println("8. Show Transaction History");
                        System.out.println("0. Back");
                        System.out.print("Enter your choice");
                        adminChoice = input.nextInt();
                        input.nextLine();

                        switch (adminChoice) {
                            case 1:
                                viewAllUsers(userIds, names, emails, phonenumbers, balance, accountStatuses);
                                break;
                            case 2:
                                System.out.println("Enter ID,name,email,or phone: ");
                                String key = input.nextLine();
                                SearchUser(key, userIds, names, emails, phonenumbers, balance, accountStatuses);
                                break;
                            case 3:
                                System.out.println("Enter user ID: ");
                                String targetId = input.nextLine();
                                viewUserDetails(targetId, userIds, names, emails, phonenumbers, balance, accountStatuses);
                                break;
                            case 4:
                                System.out.println("Enter user ID: ");
                                String updatedID = input.nextLine();
                                System.out.println("Enter new name");
                                String newName = input.nextLine();
                                System.out.println("Enter new email");
                                String newEmail = input.nextLine();
                                System.out.println("Enter new phone: ");
                                String newPhone = input.nextLine();
                                updateUser(updatedID, newName, newEmail, newPhone, userIds, names, emails, phonenumbers, balance, accountStatuses);
                                break;
                            case 5:
                                System.out.println("Enter user ID to block: ");
                                String blockId = input.nextLine();
                                blockAccounts(blockId, userIds, accountStatuses);
                                break;
                            case 6:
                                System.out.println("Enter user ID to unblock: ");
                                String unblockedId = input.nextLine();
                                unblockAccount(unblockedId, userIds, accountStatuses);
                                break;
                            case 7:
                                showStatistics(accountStatuses,transactionStatuses);
                                break;
                            case 8:
                                ShowTransactionHistory(transactionIds,transactionSenders,transactionReceivers,transactionAmounts,transactionStatuses);
                                break;
                            case (0):
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice ");
                        }
                    } while (adminChoice != 0);
                    break;
                case 2:
                    login();
                    if (loggedyuserindex == -1) {
                        break;
                    }
                    if ("BLOCKED".equalsIgnoreCase(accountStatuses[loggedyuserindex])) {
                        System.out.println("Your account is blocked");

                        logout();
                        break;
                    }
                    do {
                        System.out.println("============ User Menu ===========");
                        System.out.println("1. Show Balance");
                        System.out.println("2. Transfer Money");
                        System.out.println("3. Transfer history");
                        System.out.println("4. Add Favourite");
                        System.out.println("5. Remove Favourite");
                        System.out.println("6. Show Favourite List");
                        System.out.println("7. Search Recipient");
                        System.out.println("8. View Profile");
                        System.out.println("9. Update Profile");
                        System.out.println("10. Logout");
                        userChoice = input.nextInt();
                        input.nextLine();


                        switch (userChoice) {
                            case 1:
                                showbalance();
                                break;
                            case 2:
                                transferMoney();
                                break;
                            case 3:
                                transferhistory();
                                break;
                            case 4:
                                addfavorite();
                                break;
                            case 5:
                                removefavourits();
                                break;
                            case 6:
                                showfavouritelist();
                                break;
                            case 7:
                                searchrecipient();
                                break;
                            case 8:
                                viewprofile();
                                break;
                            case 9:
                                updateprofile();
                                break;
                            case 10:
                                logout();
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (userChoice != 10);
                    break;

                case 0:
                    System.out.println("program closed. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}























































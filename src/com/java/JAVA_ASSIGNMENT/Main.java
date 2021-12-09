package com.java.JAVA_ASSIGNMENT;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static com.java.JAVA_ASSIGNMENT.CartDaoImp.userCartDatabase;
import static com.java.JAVA_ASSIGNMENT.FavoritesDaoImp.userFavoritesDatabase;
import static com.java.JAVA_ASSIGNMENT.FeedbackDaoImp.feedbackDataBase;
import static com.java.JAVA_ASSIGNMENT.OrdersDaoImp.orderDatabase;
import static com.java.JAVA_ASSIGNMENT.ProductDaoImp.productDatabase;
import static com.java.JAVA_ASSIGNMENT.CustomerDaoImp.customerDatabase;
import static com.java.JAVA_ASSIGNMENT.SellerDaoImp.sellerDatabase;
import static com.java.JAVA_ASSIGNMENT.NotificationDaoImp.sellerNotificationDatabase;
import static com.java.JAVA_ASSIGNMENT.SellerTransactionDaoImp.sellerTransactionDatabase;


public class Main {

    public static Customer sessionCustomer;
    public static Seller sessionSeller;
    public static Scanner input = new Scanner(System.in);
    static CartDao cartDAO = new CartDaoImp();
    static ProductDao productDAO = new ProductDaoImp();
    static WalletDao walletDAO = new WalletDaoImp();
    static OrderDao orderDAO = new OrdersDaoImp();
    static WalletTransactionDao walletTransactionDAO = new WalletTransactionDaoImp();
    static SellerTransactionDao sellerTransactionDAO = new SellerTransactionDaoImp();
    static CustomerDao customerDAO = new CustomerDaoImp();
    static SellerDao sellerDAO = new SellerDaoImp();
    static NotificationDao notificationDAO = new NotificationDaoImp();
    static FeedbackDao feedbackDAO = new FeedbackDaoImp();
    static FavoritesDao favoriteDAO = new FavoritesDaoImp();

    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");




    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public static void mainMenuPage() {

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ OMAZON ONLINE SHOPPING APP ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("Welcome digital nomads. We know how important Omazon is in your life to survive this pandemic.");
        System.out.println("But ... first , tell us who you are ?");

        System.out.println("S. Seller and I'm going to sell great products! ");
        System.out.println("C. Customer and I cant wait to buy ! ");

        char userRole = 'n';
        boolean validInput;
        do{  //
            System.out.print("\nYour are ? : ");
            userRole = input.next().charAt(0);

            if(userRole == 'S' || userRole == 'C' ){
                validInput = true;
            }else{
                System.out.print("Oops wrong value, please enter either S or C.");
                validInput = false;
            }
        }while(!validInput);


        System.out.println("Before showing your shopping ability , please choose to ");
        System.out.println("1. Login");
        System.out.println("2. Register");

        int userChoice;
        do{
            System.out.print("\nYour option : ");
             userChoice = input.nextInt();

            if(userChoice == 1 || userChoice == 2 ){
                validInput = true;
            }else{
                System.out.print("Oops wrong value, please enter either 1 or 2.");
                validInput = false;
            }
        }while(!validInput);


        if (userRole == 'S') {

            if (userChoice == 1) {
                loginPage('S');
            } else {
                registerPage('S');
                loginPage('S');
            }

        } else {

            if (userChoice == 1) {
                loginPage('C');
            } else {
                registerPage('C');
                loginPage('C');
            }
        }

    }

    public static void loginPage(char userRole) {

        System.out.println("########----- L O G I N  P A G E-----########");

        String inputEmail = "";
        String inputPassword = "";


        // FOR CUSTOMER
        //1. Get email & password , then create a instance of user and set email and password
        //2. Check if this customer is found in the customerDatabase
        //3. If found then copy to sessionCustomer
        //4. Redirect user to  Home Page
        if (userRole =='C')
        {
            System.out.print("Your email : ");
            inputEmail = input.next();

            System.out.print("Your Password : ");
            inputPassword = input.next();

            Customer loginCustomer = new Customer(inputEmail,inputPassword);
            customerDAO.loginCustomer(loginCustomer);

            homePage();
        }else{

            System.out.print("Enter your email : ");
            inputEmail = input.next();

            System.out.print("Password : ");
            inputPassword = input.next();

            Seller loginSeller = new Seller(inputEmail,inputPassword);
            sellerDAO.loginSeller(loginSeller);

            sellerDashboardPage();
        }

    }

    public static void logOutPage(char userRole){

        if (userRole =='C')
        {
            System.out.print("Thank you for shopping. You have been logged out. You will be now redirected to Main Menu Page");

        }else{

            System.out.print("Thank you for your service. You have been logged out.You will be now redirected to Main Menu Page");
        }

        promptEnterKey();
        mainMenuPage();

    }



    public static void registerPage(char userRole) {
        System.out.println("########----- R E G I S T R A T I O N  P A G E-----########");

        String inputEmail = "";

        if (userRole =='C')
        {
            Customer registerCustomer = new Customer();

            System.out.print("Your Email : ");
            inputEmail=input.next();
            //Perform Data validation for email , then only set it
            registerCustomer.setEmail(inputEmail);

            System.out.print("Your Password : ");
            registerCustomer.setPassword(input.next());
            System.out.print("Your Username : ");
            registerCustomer.setUsername(input.next());
            System.out.print("Your First Name : ");
            registerCustomer.setFirstName(input.next());
            System.out.print("Your Last Name : ");
            registerCustomer.setLastName(input.next());
            System.out.print("Your Address : ");
            registerCustomer.setAddress(input.next());
            System.out.print("Your Payment Password : ");
            registerCustomer.setPaymentPassword(input.next());

            CustomerDao customerDAO = new CustomerDaoImp();
            customerDAO.registerCustomer(registerCustomer);
        }
        else{

            Seller registerSeller = new Seller();

            System.out.print("Your Email : ");
            registerSeller.setEmail(input.next());

            System.out.print("Your Password : ");
            registerSeller.setPassword(input.next());

            System.out.print("Your Username : ");
            registerSeller.setUsername(input.next());

            System.out.print("Your IC Number : ");
            registerSeller.setSellerIC(input.next());

            System.out.print("Your Business Registration Number : ");
            registerSeller.setSellerBusinessRegistrationNumber(input.next());

            System.out.print("Your Phone Number : ");
            registerSeller.setSellerPhoneNumber(input.next());

            System.out.print("Your Address : ");
            registerSeller.setSellerAddress(input.next());

            System.out.print("Your Bank account : ");
            registerSeller.setSellerBankAccount(input.next());

            sellerDAO.registerSeller(registerSeller);
        }





    }


    public static void homePage() {

        System.out.println("########----- H O M E  P A G E-----########");


        ProductDao productDAO = new ProductDaoImp();
        ArrayList<Product> top3SellingProducts = productDAO.getTop3SellingProduct();
        // List 3 Best Selling Products ( A , B , C)  getTop3SellingProduct()
        System.out.println("TOP SELLING PRODUCTS");
        for (int i = 0; i < top3SellingProducts.size(); i++) {

            System.out.println( "NO."+(i+1)+" - "+ top3SellingProducts.get(i).getProductName());

        }


        System.out.println("1.Search");
        System.out.println("2.Check Wallet");
        System.out.println("3.View Cart");
        System.out.println("4.View Favorites");
        System.out.println("5.View Categories");
        System.out.println("6.Log Out");
        System.out.println("Your choice : ");
        int userChoice = input.nextInt();         // Get the choice

        boolean validInput;
        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 5 ){
                    System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 or 6 only.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);



        switch (userChoice) {
            case 1:
                System.out.println("This is search Page ");
                searchPage();
                break;
            case 2:
                System.out.println("This is wallet Page ");
                walletPage(sessionCustomer.getUsername());
                break;
            case 3:
                System.out.println("This is cart Page ");
                cartPage();
                break;
            case 4:
                System.out.println("This is  favorites Page ");
                favoritesPage();
                break;
            case 5:
                System.out.println("This is category Page ");
                categoryPage();
                break;
            case 6:
                System.out.println("This is logout Page ");
                logOutPage('C');
                break;

        }


    }

    public static void searchPage() {

        boolean searchByProduct = false;
        String term;

        //result of searching simillar term
        ArrayList<Product> searchResult = new ArrayList<>();

        Out:
        do{
            // Present Options -> 1. Search by Product , 2. Search by Seller
            System.out.print("1. Search by product\n2. Search by seller\nEnter command:");

            // Get the choice  [DATA VALIDATION]

            switch(input.nextLine().charAt(0)){
                // After validation and checking the choice get the search term
                case '1':
                    searchByProduct = true;
                    // continue run the code in case '2'
                case '2':
                    //only search for frist 15 characters
                    term = input.nextLine().substring(0, 15);
                    break Out;
                default:
                    System.out.println("Invalid input");
            }
        }while(true);

        // require a method in class ProductDao to return an ArrayList contain all Product in database, will raise as an issue
        ArrayList<Product> list = productDAO.getListOfAllProduct();

        // Search through the ArrayList of Product , if it matches the search term
        // Test and  get the size of list outside the loop to improve preformance
        // *Focus on for loop to improve preformance
        // The code has linear order of grow for size of list,may slow if list contain too many element
        // ***Don't use the code with list with too many element like more than ten thousand
        long size =  list.size();
        if(searchByProduct){
            for (long i = 0; i < size; i++){
                Product temp = list.get((int) i);
                //check does name of product contain term or term contain name of product
                if(temp.getProductName().contains(term) || term.contains(temp.getProductName()))
                    //if true,add product into array list
                    searchResult.add(temp);
            }
        }
        else{
            for (long i = 0; i < size; i++){
                Product temp = list.get((int) i);
                // check does name of seller contain term or term contain name of seller
                // dont use function getListOfThisSeller
                // to enable user input Tan , seller Tan Chun Hong and James Tan came out(two different seller)
                if(temp.getProductSellerUsername().contains(term) || term.contains(temp.getProductSellerUsername()))
                    searchResult.add(temp);
            }
        }
        // Now the arraylist searchResult contain the results which have similar keywords

        // Then display list of products based on that search term
        int index = 0;
        nextPage:
        do{
            System.out.println("Product ID     Name           Category       Price");
            for(int i = 0; i < 20 && index < list.size(); i++, index++)
                System.out.printf("%-15.15s%-15.15s%-15.15s%-15.2f\n", list.get(index).getProductID(), list.get(index).getProductName(), list.get(index).getProductCategory(),
                        list.get(index).getProductPrice());

            // Get user choice of product
            System.out.print("(1) for next page\n(2) for exit\nEnter product id to view product:");
            String id = input.next();
            switch(id.charAt(0)){
                case '1':
                    break nextPage;
                case '2':
                    return;
                default:
                    // Then direct Product Display Page
                    productDisplayPage(id);
            }
        }while(true);
    }


       public static void walletPage(String userName) {

        System.out.println("########----- W A L L E T  P A G E-----########");
        WalletDao userWallet = new WalletDaoImp();
        WalletTransactionDao walletTransactionDAO = new WalletTransactionDaoImp();

        char userChoice;
        boolean validInput=true;
        // Display current balance
        CustomerDao customerDAO=new CustomerDaoImp();
        System.out.print("Current Balance : RM ");

        System.out.println(customerDAO.getCustomer(userName).getUserWallet());
        System.out.println("1. Top Up Balance");
        System.out.println("2. View Transaction");
        System.out.println("R. Return Home Page");

        do {
            System.out.println("\nYour option : ");
            userChoice = input.next().charAt(0);
            //-> 1. Top Up Balance    , userWallet.topUpWalletBalance(0.00);
            if (userChoice == '1') {
                validInput = true;
                System.out.print("Enter the amount to top up : RM ");
                userWallet.topUpWalletBalance(input.nextDouble());
                System.out.print("Top up Successful");

            }
            //-> 2. View Transactions ,  walletTransactionDAO.getWalletTransaction()
            else if (userChoice == '2') {
                validInput = true;
                System.out.println("No      Transaction ID        Amount       Date & Time");

                // If user chose to view transactions
                for (int i = 0; i < walletTransactionDAO.getWalletTransaction().size(); i++) {
                    WalletTransaction printTransaction = walletTransactionDAO.getWalletTransaction().get(i);

                    System.out.println((i+1)+
                            printTransaction.getTransactionID() +
                                    printTransaction.getTransactionAmount() +
                                    printTransaction.getTransactionDateTime()
                    );
                }

            }
            //-> R. Return Home Page
            else if (userChoice != 'R') {
                System.out.print("Oops wrong value, please enter either 1 or 2.");
                validInput = false;
            }
        }while (!validInput);
    }


    public static void cartPage() {


            ArrayList<Cart> cartDetailsOfThisUser = cartDAO.getCart(sessionCustomer.getUsername());

            if( cartDetailsOfThisUser !=null){
                double totalAmount = 0.0;

                System.out.println("No      Product Name        Price       Quantity");
                for (int i = 0; i < cartDetailsOfThisUser.size(); i++) {

                    Cart cart = cartDetailsOfThisUser.get(i);
                    Product productsInCartToDisplay = productDAO.getProduct(cart.getCartProductID());
                    System.out.println((i + 1) + "      " +
                            productsInCartToDisplay.getProductName() + "      " +
                            productsInCartToDisplay.getProductPrice() + "      " +
                            cart.getCartQuantity());

                    totalAmount += productsInCartToDisplay.getProductPrice();

                }

                System.out.printf("Total Amount in Cart : RM %.2f", totalAmount);
                System.out.println("What would you like to do ?");
                System.out.println("1. Checkout Now");
                System.out.println("2. Return to Home");

                boolean validInput;
                int userChoice = 0;

                do {
                    try {
                        System.out.print("\nYour option : ");
                        userChoice = input.nextInt();
                        validInput = true;

                        if (userChoice < 1 || userChoice > 2) {
                            System.out.print("Oops wrong value, please enter either 1 or 2.");
                            validInput = false;
                            input.nextLine();
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("You have entered an invalid format of input");
                        validInput = false;
                        input.nextLine();
                    }

                } while (!validInput);


                if (userChoice == 1) {
                    System.out.println("You will be now directed to Checkout page");
                    checkoutPage(cartDetailsOfThisUser, totalAmount);

                } else {
                    System.out.println("You will be now directed to Home page");
                }

            }else{
                System.out.println("Ooops , there is no products in your cart. Please add products in your cart !");
            }



    }

    public static void favoritesPage() {

        //using for loop on userFavoritesDatabase
        //display all objects that matches with the current user
        // if no then display necessary message

        ArrayList<Favorites> listOfFavorites = favoriteDAO.getListOfFavorites(sessionCustomer.getUsername());

        if (listOfFavorites != null) {

            System.out.println("No      Product Name        Price ");
            for (int i = 0; i < listOfFavorites.size(); i++) {

                Favorites favorite = listOfFavorites.get(i);

                System.out.println((i + 1) + "      " +
                        favorite.getFavoritesProduct().getProductName() + "      " +
                        favorite.getFavoritesProduct().getProductPrice());
            }

        }else{
            System.out.println("Oops sorry , no products added to your favorites");
        }

        System.out.println("You will be now redirected to to Home Page");
        promptEnterKey();
    }

    public static void categoryPage() {
        System.out.println("########----- C A T E G O R Y  P A G E-----########");

        //Array of Strings that contains all the categories String categories = {".." , "..."}
        String[] category = new String[]{"Women Clothes","Men Clothes","Health & Beauty","Mobile & Accessories",
                "Baby & Toys","Watches","Home & Living","Home Appliances","Women's Bags","Men's Bags & Wallets",
                "Muslim Fashion","Computer & Accessories","Groceries & Pets","Sport & Outdoor","Women Shoes",
                "Men Shoes","Fashion Accessories","Games, Books & Hobbies","Automotive","Tickets & Vouchers"};


        // Display list of Categories // Options -> 1. Men Clothes , 2.Women Clothes.... R.Return
        for (int i=0; i< category.length; i++){
            System.out.println("Category ID    Category Name");
            System.out.println(i+1+". "+category[i]);
        }


        //LAGU AMARAN

            // Get user choice  [DATA VALIDATION]
            int userChoice=0;
            boolean validInput;

            System.out.println("What would you like to do ?");
            System.out.println("1. Choose a category to view the products");
            System.out.println("2. Return to Home");
            userChoice = input.nextInt();


        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 2 ){
                    System.out.print("Oops wrong value, please enter either 1 or 2.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);


        if( userChoice ==1){

            System.out.println("Type the category No : ");
            int categoryNo = input.nextInt();

         ArrayList<Product> listOfProductsBasedOnCategory = productDAO.getListOfProductsBasedOnCategory(category[categoryNo]);

         if(listOfProductsBasedOnCategory != null ){

             System.out.println("List of Products in "+ category[categoryNo] );
             System.out.println("Product ID    Product Name");

             for (int i = 0; i < listOfProductsBasedOnCategory.size(); i++) {
                 System.out.println(listOfProductsBasedOnCategory.get(i).getProductID() +". "+listOfProductsBasedOnCategory.get(i).getProductName() );
             }

             System.out.println("What would you like to do ?");
             System.out.println("1. View a product");
             System.out.println("2. Return   ");
             userChoice = input.nextInt();

             do{
                 try {
                     System.out.print("\nYour option : ");
                     userChoice = input.nextInt();
                     validInput=true;

                     if(userChoice < 1 || userChoice  > 2 ){
                         System.out.print("Oops wrong value, please enter either 1 or 2.");
                         validInput = false;
                         input.nextLine();
                     }
                 }
                 catch (InputMismatchException ex) {
                     System.out.println("You have entered an invalid format of input");
                     validInput=false;
                     input.nextLine();
                 }

             }while(!validInput);

             if(userChoice ==1){
                 System.out.println("Type the Product ID : ");
                 String productID = input.nextLine();

                 productDisplayPage(productID);

             }else{
                 //return
             }
         }else{
             System.out.println("Oops sorry , no products yet. They're on the way");

         }



        }else{

            //return home page
        }

    }

    public static void productDisplayPage(String productID) {

        System.out.println("########----- P R O D U C T  P A G E-----########");

        Product searchedProduct =productDAO.getProduct(productID);
        if ( searchedProduct != null){

            System.out.println(
                    searchedProduct.getProductName() +
                            searchedProduct.getProductCategory() +
                            searchedProduct.getProductDescription() +
                            searchedProduct.getProductPrice()
            );

            Feedback searchedProductFeedback =feedbackDAO.getFeedback(productID);

            System.out.println(
                    searchedProductFeedback.getFeedbackReview() +
                            searchedProductFeedback.getFeedbackCommentBySeller()
            );


            System.out.println("What would you like to do ?");
            System.out.println("1. Add to cart");
            System.out.println("2. Add to favorites");

            int userChoice=0,cartQuantity=0;
            boolean validInput;

            do{
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput=true;

                    if(userChoice < 1 || userChoice  > 2 ){
                        System.out.print("Oops wrong value, please enter either 1 or 2.");
                        validInput = false;
                        input.nextLine();
                    }
                }
                catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput=false;
                    input.nextLine();
                }

            }while(!validInput);


            if (userChoice == 1) {

                do{
                    try {
                        System.out.print("\nEnter quantity in digits (Eg :25");
                        cartQuantity= input.nextInt();
                        validInput=true;

                    }
                    catch (InputMismatchException ex) {
                        System.out.println("You have entered an invalid format of input");
                        validInput=false;
                        input.nextLine();
                    }

                    Cart addToCart = new Cart(productID,cartQuantity,sessionCustomer.getUsername());
                    CartDao cartDAO = new CartDaoImp();
                    cartDAO.addCart(addToCart);

                    System.out.println("Great this product is added to cart with the quantity !" + cartQuantity);

                }while(!validInput);

            } else {

                Favorites addToFavorites = new Favorites(searchedProduct,sessionCustomer.getUsername());
                FavoritesDao favoritesDAO = new FavoritesDaoImp();
                favoritesDAO.addFavorites(addToFavorites);
                System.out.println("Great this product is added to favorites !");
            }

        }else{

            System.out.println("Oops sorry couldn't find the product you're looking for. Please enter the product ID correctly");
        }


    }


    public static void checkoutPage(ArrayList<Cart> cartDetailsOfThisUser, double totalCheckoutAmount) {


        // todo : shipping fees
        for (int i = 0; i < cartDetailsOfThisUser.size(); i++) {

            Cart cart = cartDetailsOfThisUser.get(i);
            Product productsInCartToDisplay = productDAO.getProduct(cart.getCartProductID());
            System.out.println((i+1)+"      "+
                    productsInCartToDisplay.getProductName() +"      "+
                    productsInCartToDisplay.getProductPrice()+"      " +
                    cart.getCartQuantity());


        }
        System.out.println("Total Amount to Checkout : " + totalCheckoutAmount);


        System.out.println("What would you like to do ?");
        System.out.println("1. Pay Now");
        System.out.println("2. Return to Home");

        boolean validInput;
        int userChoice=0;

        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 2 ){
                    System.out.print("Oops wrong value, please enter either 1 or 2.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);


        if (userChoice == 1) {

            // TODO : FORGOT PASSWORD
            String paymentPassword;
            do {
                System.out.println("Enter your payment password :");
                 paymentPassword = input.next();

                 if (!customerDAO.checkPaymentPassword(paymentPassword) ){
                     System.out.println("Uh Oh , wrong password. Try again:");
                 }

            }while(!customerDAO.checkPaymentPassword(paymentPassword));



            while(sessionCustomer.getUserWallet().getWalletBalance() < totalCheckoutAmount){

                System.out.println("Insufficient Balance , please Top Up. Your balance in wallet is "+sessionCustomer.getUserWallet().getWalletBalance());

                System.out.println("What would you like to do ?");
                System.out.println("1. Top Up my Wallet and Proceed Payment");
                System.out.println("2. Cancel this transaction");

                do{
                    try {
                        System.out.print("\nYour option : ");
                        userChoice = input.nextInt();
                        validInput=true;

                        if(userChoice < 1 || userChoice  > 2 ){
                            System.out.print("Oops wrong value, please enter either 1 or 2.");
                            validInput = false;
                            input.nextLine();
                        }
                    }
                    catch (InputMismatchException ex) {
                        System.out.println("You have entered an invalid format of input");
                        validInput=false;
                        input.nextLine();
                    }

                }while(!validInput);

                if (userChoice == 1) {

                    WalletDao walltetDao = new WalletDaoImp();
                    //TODO: Input Validation
                    System.out.println("Enter the amount you would like to top up : RM ");
                    double topUpAmount = input.nextDouble();
                    walltetDao.topUpWalletBalance(topUpAmount);

                }else{
                        break;
                }

            }


            //Once there is Sufficient balance , proceed the checkout process
            LocalDateTime myDateObj = LocalDateTime.now();
            String formattedDate = myDateObj.format(myFormatObj);

            //Add New Order
            ArrayList <Orders> ListofOrdersForTransaction = new ArrayList<>();

            for (int i = 0; i < cartDetailsOfThisUser.size(); i++) {

                Cart cart = cartDetailsOfThisUser.get(i);
                Product productsInCartForOrders = productDAO.getProduct(cart.getCartProductID());
                String uniqueID = UUID.randomUUID().toString().substring(0,8);

                Orders order = new Orders(
                        "Unprocessed" ,
                        "OD"+uniqueID,
                        formattedDate,
                        sessionCustomer.getUsername(),
                        false,
                        "Track Not Set",
                        false,
                        productsInCartForOrders.getProductSellerUsername(),
                        productsInCartForOrders,
                        cart.getCartQuantity()
                        );
                // Add Orders
                ListofOrdersForTransaction.add(order);
                orderDAO.addOrders(order);

                //Increase Sales Count of this product
                productDAO.reduceProductStock(productsInCartForOrders,cart.getCartQuantity());

                //Reduce Stock Count of this product
                productDAO.addProductSalesCount(productsInCartForOrders,cart.getCartQuantity());

                //Removing from user's cart
                cartDAO.deleteCart(cartDetailsOfThisUser.get(i));

                // Notify the seller
                Notification notificationSeller = new Notification(false,productsInCartForOrders.getProductSellerUsername(),"OD"+uniqueID,sessionCustomer.getFirstName()+" "+sessionCustomer.getLastName(),productsInCartForOrders.getProductName());
                notificationDAO.addNotification(notificationSeller);

                // Add transaction for seller
                String uniqueTransactionID = UUID.randomUUID().toString().substring(0,8);
                SellerTransaction sellerTransaction = new SellerTransaction(
                        "TRS"+uniqueTransactionID,
                        productsInCartForOrders.getProductPrice(),
                        formattedDate,
                        productsInCartForOrders.getProductSellerUsername());
                sellerTransactionDAO.addSellerTransaction(sellerTransaction);
                sellerDAO.updateSellerProfit( productsInCartForOrders.getProductSellerUsername(),productsInCartForOrders.getProductPrice());

            }


            //Reduce Wallet Balance
            walletDAO.reduceWalletBalance(totalCheckoutAmount);

            //Add Wallet Transaction
            String uniqueID = UUID.randomUUID().toString().substring(0,8);
            WalletTransaction transaction = new WalletTransaction(
                    "TR"+uniqueID ,
                    totalCheckoutAmount,
                    formattedDate,
                    sessionCustomer.getUsername()
                    );
            walletTransactionDAO.addWalletTransaction(transaction);

            System.out.println("Payment Successful , you will be now directed to Order History page");

            orderHistoryPage();

        } else {
            System.out.println("You will be now directed to Home page");
        }





    }

    public static void orderHistoryPage() {

        System.out.println("########----- P R O D U C T  P A G E-----########");

        System.out.println("No      Order ID    Order Date      Product Name       Order Status       Seller");

        ArrayList <Orders> listOfOrders = orderDAO.getListOfOrdersOfCustomer(sessionCustomer.getUsername());
        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println((i + 1) + "      " +
                    listOfOrders.get(i).getOrderID() + "      " +
                    listOfOrders.get(i).getOrderDate() + "      " +
                    listOfOrders.get(i).getOrderProduct().getProductName() + "      " +
                    listOfOrders.get(i).getOrderProduct().getProductPrice() + "      " +
                    listOfOrders.get(i).getOrderQuantity() + "      " +
                    listOfOrders.get(i).getOrderSellerUsername());
        }

        System.out.println("1.View details of an Order");
        System.out.println("2.Return to home page");
        System.out.println("Your option : ");
        int userChoice= input.nextInt();         // Get the choice


        boolean validInput;
        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 2 ){
                    System.out.print("Oops wrong value, please enter either 1 or 2 only.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);


        if(userChoice ==1){

            System.out.println("Enter the Order ID to view the details : ");
            String orderID= input.next();

            //If want to view more details

            Orders order= orderDAO.getOrders(orderID);

            System.out.println(
                        "Order ID     : "+ order.getOrderID() + "\n" +
                        "Order Date   : "+order.getOrderDate() + "\n" +
                        "Order Status : "+order.getOrderStatus()+ "\n" +
                        "Product Name : "+order.getOrderProduct().getProductName() + "\n" +
                        "Product Price    : "+order.getOrderProduct().getProductPrice() + "\n" +
                        "Quantity Ordered : "+order.getOrderQuantity() + "\n");

            if(!Objects.equals(order.getOrderStatus(), "Unprocessed")){
                System.out.println("Tracking ID : "+order.getOrderStatus()+ "\n" );

                System.out.println("\nPlease update the Delivery of this Order");

                    System.out.println("Have you received the order ? Y = Yes or N = No");
                    char orderReceivedConfirmation = input.next().charAt(0);

                    if (orderReceivedConfirmation == 'Y'){
                        System.out.println("Thank you for confirmation");
                        order.setOrderStatus("Delivered");
                        order.setOrderReceivedOrNot(true);
                        //TODO : DATA VALIDATION
                        System.out.println("\nPlease rate this order from 1 - 5");
                        int prodRating = input.nextInt();

                        System.out.println("\nPlease leave your feedback ");
                        String prodfeedback = input.nextLine();

                        Feedback fdbkProd = new Feedback(
                                order.getOrderProduct(),
                                prodfeedback,
                                "None",
                                sessionCustomer.getFirstName()+" "+sessionCustomer.getLastName(),
                                prodRating);
                    }

            }



        }else{
            System.out.println("You will be redirected to Home Page");
        }





    }

    public static void feedbackPage() {
        // Find orders of this user that has not Rated & Received
        // Display the product [ Name and ID ] from that order
        // Get Review & Rating
        // ^ Loop all the products from that order
        // Once all the products have been reviewed from that one order , Update the Rated attributed to "Yes" of that order
        // Then proceed to check for other orders
        // ** Its definitely going to be a loop inside a loop inside a loop


    }

    public static void userProfilePage() {

        boolean validInput;

        System.out.println("########----- P R O F I L E   P A G E-----########");
        System.out.println("1.Change Username");
        System.out.println("2.Change Email");
        System.out.println("3.Change Password");
        System.out.println("4.Update address");
        System.out.println("5.Delete Account");
        System.out.println("Your option : ");
       int userChoice= input.nextInt();         // Get the choice


        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 5 ){
                    System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 or 5 only.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);




        switch (userChoice) {
            case 1:
                    System.out.println("Your new username: ");
                    String username = input.next();
                    customerDAO.updateUsername(username);
                    break;
            case 2:
                    System.out.println("Your new Email: ");
                    String email = input.next();
                    customerDAO.updateEmail(email);
                    break;
            case 3:
                    System.out.println("Your new Password: ");
                    String password = input.next();
                    customerDAO.updatePassword(password);
                    break;
            case 4:
                    System.out.println("Your new Address: ");
                    String address = input.nextLine();
                    customerDAO.updateAddress(address);
                    break;
            default:
                    System.out.println("Are you sure to delete the account?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");

                    int deleteConfirmation= 0;
                    do{
                        try {
                            System.out.print("\nYour option : ");
                            deleteConfirmation = input.nextInt();
                            validInput=true;

                            if(deleteConfirmation < 1 || deleteConfirmation  > 2 ){
                                System.out.print("Oops wrong value, please enter either 1 or 2.");
                                validInput = false;
                                input.nextLine();
                            }
                        }
                        catch (InputMismatchException ex) {
                            System.out.println("You have entered an invalid format of input");
                            validInput=false;
                            input.nextLine();
                        }

                    }while(!validInput);

                    if (deleteConfirmation == 1) {
                        customerDAO.deleteCustomer(sessionCustomer);
                    } else {
                        // back to the userProfilePage!!! Then choice again!
                    }
                break;

        }




    }

    public static void exitApp() {

    }


    public static void sellerDashboardPage() {

        boolean returnToDashboard =true ;

        do{
            System.out.println("########----- D A S H B O A R D   P A G E-----########");
            System.out.println("1. Manage Orders");
            System.out.println("2. Manage Products");
            System.out.println("3. Manage Feedbacks");
            System.out.println("4. Manage Payment");
            System.out.println("5. Manage Profile");
            System.out.println("6. Log Out");

            int userChoice = 0;
            boolean validInput;
            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 6) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 or 6 only.");
                        validInput = false;
                        input.nextLine();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

            } while (!validInput);


            switch (userChoice) {

                case 1: manageOrdersPage();
                    break;
                case 2: manageProductPage();
                    break;
                case 3: manageFeedbackPage();
                    break;
                case 4: managePaymentPage();
                    break;
                case 5:manageSellerProfilePage();
                    break;
                case 6: returnToDashboard=false;
                    break;
            }


        }while(returnToDashboard);

        logOutPage('s');

    }




    public static void addProductPage(){

        //Generate product id, SHOULD HAVE A METHOD IN ProductDOA DO THIS
        String productID = productDAO.generateProductID();

        // Get the name, using nextLine to allow have space between name of product
        System.out.print("Enter the name of product:");
        String name = input.nextLine();

        System.out.print("Enter the category of product:");
        String category = input.nextLine();

        System.out.print("Enter the description of product:");
        String descrip = input.nextLine();

        System.out.print("Enter the price of product:");
        double price = input.nextDouble();

        System.out.print("Enter the stock of product:");
        int stock = input.nextInt();

        //Get productDOA in seller class, write a method to return object of ProductDOA
        productDAO.addProduct(new Product(productID, name, descrip, category, sessionSeller.getSellerUsername(),price, stock, 0));

        System.out.println("Successfully add product");
    }

    public static void updateProductPage( ){

        char contUpdateConfirmation ='N';
        do {
            System.out.print("Enter the Product ID to update :");
            String productID = input.next();

            Product product = productDAO.getProduct(productID);

            if (product != null) {

                System.out.println("1.Update Name\n2.Update Description \n3. Update Category\n4.Update Stock\n5. Update Price\n6. Return");
                int userChoice = 0;
                boolean validInput;
                do {
                    try {
                        System.out.print("\nYour option : ");
                        userChoice = input.nextInt();
                        validInput = true;

                        if (userChoice < 1 || userChoice > 6) {
                            System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 or 6 only.");
                            validInput = false;
                            input.nextLine();
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("You have entered an invalid format of input");
                        validInput = false;
                        input.nextLine();
                    }

                } while (!validInput);


                switch (userChoice) {

                    case 1:
                        product.setProductName(input.nextLine());
                        productDAO.updateProduct(product);
                        break;
                    case 2:
                        product.setProductDescription(input.nextLine());
                        productDAO.updateProduct(product);
                        break;
                    case 3:
                        product.setProductCategory(input.nextLine());
                        productDAO.updateProduct(product);
                        break;
                    case 4:
                        product.setProductStockCount(input.nextInt());
                        productDAO.updateProduct(product);
                        break;
                    case 5:
                        product.setProductPrice(input.nextDouble());
                        productDAO.updateProduct(product);
                        break;

                }

                System.out.print("Product Updated successfully !");

            } else {
                System.out.print("Uh oh , product is not found please enter correct product ID");
                System.out.print("Do you still want to update ? Press 'Y' for YES  and Press 'N' for NO");
                contUpdateConfirmation = input.next().charAt(0);
            }

        }while(contUpdateConfirmation=='Y');


    }

    public static void deleteProductPage(){
        System.out.print("Enter the Product ID to delete :");
        String productID = input.next();

       Product product =  productDAO.getProduct(productID);
        char contUpdateConfirmation ='N';

        do{
        if (product != null) {
            productDAO.deleteProduct(product);
            System.out.println("Successfully deleted product");

        }else {
            System.out.print("Uh oh , product is not found please enter correct product ID");
            System.out.print("Do you still want to delete ? Press 'Y' for YES  and Press 'N' for NO");
            contUpdateConfirmation = input.next().charAt(0);
        }

        }while(contUpdateConfirmation=='Y');

    }



    public  static void searchAndDisplayProductPage(){
        System.out.print("Enter the Product ID to search:");
        String productID = input.next();

        Product product =  productDAO.getProduct(productID);
        char contUpdateConfirmation ='N';

        do{
            if (product != null) {
                System.out.println(
                        product.getProductName() +
                                product.getProductCategory() +
                                product.getProductDescription() +
                                product.getProductPrice()
                );

                Feedback searchedProductFeedback =feedbackDAO.getFeedback(productID);

                System.out.println(
                        searchedProductFeedback.getFeedbackReview() +
                                searchedProductFeedback.getFeedbackCommentBySeller()
                );
            }else {
                System.out.print("Uh oh , product is not found please enter correct product ID");
                System.out.print("Do you still want to search ? Press 'Y' for YES  and Press 'N' for NO");
                contUpdateConfirmation = input.next().charAt(0);
            }

        }while(contUpdateConfirmation=='Y');
    }

    public static void manageProductPage() {

        boolean returnToManageProductPage = true;

        do {
            System.out.println("########----- MANAGE PRODUCT PAGE-----########");

            System.out.println("1.View list of products \n2.Add product  \n3.Update product  \n4.Delete product  \n5.Search a product \n6.Return to Dashboard");
            System.out.println("Your choice :");

            int userChoice = 0;
            boolean validInput;

            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 6) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 or 6 only.");
                        validInput = false;
                        input.nextLine();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

            } while (!validInput);


            //Get input of a whole line and take the frist character
            switch (userChoice) {
                case 1:
                    ArrayList<Product> listOfProductOfThisSeller = productDAO.getListOfProductsOfThisSeller(sessionSeller.getSellerUsername());

                    // View list of products and stock counts
                    System.out.println("Product ID     Name           Category       Price          Stock");
                    for (int i = 0; i < listOfProductOfThisSeller.size(); i++) {
                        System.out.printf("%15s%15s%15s%15s%15s\n",
                                listOfProductOfThisSeller.get(i).getProductID(),
                                listOfProductOfThisSeller.get(i).getProductCategory(),
                                listOfProductOfThisSeller.get(i).getProductName()
                                , listOfProductOfThisSeller.get(i).getProductPrice(),
                                listOfProductOfThisSeller.get(i).getProductStockCount());
                    }

                    break;
                case 2:
                    //Add Product
                    addProductPage();
                    break;
                case 3:
                    //Update product (name ,price and stock counts)
                    updateProductPage();
                    break;
                case 4:
                    //Delete product
                    deleteProductPage();
                    break;
                case 5:
                    searchAndDisplayProductPage();
                    break;
                case 6:
                    System.out.println("You will be now redirected to Dashboard page");
                    promptEnterKey();
                    returnToManageProductPage = false;
                    break;

            }

        }while(returnToManageProductPage);




    }




    public static void manageOrdersPage() {

        System.out.println("########----- P R O D U C T  P A G E-----########");

        System.out.println("No      Order ID    Order Date      Product Name       Order Status       Customer");

        //First list all the orders that matches the seller
        ArrayList <Orders> listOfOrders = orderDAO.getListOfOrdersOfSeller(sessionSeller.getSellerUsername());
        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println((i + 1) + "      " +
                    listOfOrders.get(i).getOrderID() + "      " +
                    listOfOrders.get(i).getOrderDate() + "      " +
                    listOfOrders.get(i).getOrderProduct().getProductName() + "      " +
                    listOfOrders.get(i).getOrderStatus() + "      " +
                    listOfOrders.get(i).getOrderCustomerUserName());
        }

        System.out.println("1.View details of an Order");
        System.out.println("2.Return to home page");
        System.out.println("Your option : ");
        int userChoice= input.nextInt();         // Get the choice


        boolean validInput;
        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 2 ){
                    System.out.print("Oops wrong value, please enter either 1 or 2 only.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);


        if(userChoice ==1){

            System.out.println("Enter the Order ID to view the details : ");
            String orderID= input.next();

            //If want to view more details

            Orders order= orderDAO.getOrders(orderID);

            System.out.println(
                    "Order ID     : "+ order.getOrderID() + "\n" +
                            "Order Date   : "+order.getOrderDate() + "\n" +
                            "Order Status : "+order.getOrderStatus()+ "\n" +
                            "Product Name : "+order.getOrderProduct().getProductName() + "\n" +
                            "Product Price    : "+order.getOrderProduct().getProductPrice() + "\n" +
                            "Quantity Ordered : "+order.getOrderQuantity() + "\n");


            if(Objects.equals(order.getOrderStatus(), "Unprocessed")){

                System.out.println("Would you like to update the order ? Y = Yes or N = No");
                char orderReceivedConfirmation = input.next().charAt(0);

                if (orderReceivedConfirmation == 'Y'){
                    System.out.println("Enter the tracking ID : ");
                    order.setOrderTrackingID(input.nextLine());
                    order.setOrderStatus("Processing / Shipping");

                    orderDAO.updateOrders(order);
                }

            }


        }else{
            System.out.println("You will be redirected to Home Page");
        }


    }

    public static void manageFeedbackPage() {

        ArrayList<Feedback> feedbackOfThisSeller = new ArrayList<>();
        for (int i = 0; i < feedbackDataBase.size(); i++) {

            if (feedbackDataBase.get(i).getFeedbackProduct().getProductSellerUsername().equals(sessionSeller)) {
                feedbackOfThisSeller.add(feedbackDataBase.get(i));
            }

        }

        for (int i = 0; i < feedbackOfThisSeller.size(); i++) {

            System.out.println(feedbackOfThisSeller.get(i).getFeedbackProduct().getProductName() +
                    feedbackOfThisSeller.get(i).getFeedbackReview() +
                    feedbackOfThisSeller.get(i).getFeedbackRating() +
                    feedbackOfThisSeller.get(i).getFeedbackCustomerName() +
                    feedbackOfThisSeller.get(i).getFeedbackCommentBySeller()
            );
        }

        //Ask if seller would like to comment for any feedback
        // Options -> 1.Would you like to comment ? 2. Return


        // IF user chose to comment , ask for Feedback ID
        //Get the comment , then set it using the setter function


    }

    public static void managePaymentPage() {


        System.out.println("Total Profit : RM" + sessionSeller.getSellerProfit() + "\n");

        System.out.println("No      Transaction ID        Amount       Date & Time");

        ArrayList <SellerTransaction> listOfSellerTransaction = sellerTransactionDAO.getListOfSellerTransaction(sessionSeller.getSellerUsername());

        for (int i = 0; i < listOfSellerTransaction.size(); i++) {

            System.out.println((i+1) + "      " +
                    listOfSellerTransaction.get(i).getSellerTransactionID()  + "      " +
                    listOfSellerTransaction.get(i).getSellerTransactionAmount()  + "      " +
                    listOfSellerTransaction.get(i).getSellerTransactionDateTime()
            );


        }

        System.out.println("You will be now redirected to Dashboard Page");
        promptEnterKey();


    }

    public static void manageSellerProfilePage() {

        boolean validInput;

        System.out.println("########----- P R O F I L E   P A G E-----########");
        System.out.println("1.Change Username");
        System.out.println("2.Change Email");
        System.out.println("3.Change Password");
        System.out.println("4.Update Address");
        System.out.println("5.Change Phone Number");
        System.out.println("6.Change Bank Account");
        System.out.println("Your option : ");
        int userChoice= input.nextInt();         // Get the choice


        do{
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput=true;

                if(userChoice < 1 || userChoice  > 6 ){
                    System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 or 6 only.");
                    validInput = false;
                    input.nextLine();
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("You have entered an invalid format of input");
                validInput=false;
                input.nextLine();
            }

        }while(!validInput);



        switch (userChoice) {
            case 1:
                System.out.println("Your new username : ");
                String username = input.next();
                sessionSeller.setSellerUsername(username);
                break;
            case 2:
                System.out.println("Your new Email : ");
                String email = input.next();
                sessionSeller.setSellerEmail(email);
                break;
            case 3:
                System.out.println("Your new Password : ");
                String password = input.next();
                sessionSeller.setSellerPassword(password);
                break;
            case 4:
                System.out.println("Your new Address : ");
                String address = input.nextLine();
                sessionSeller.setSellerAddress(address);
                break;
            case 5:
                System.out.println("Your new Phone Number : ");
                String phoneNum = input.nextLine();
                sessionSeller.setSellerPhoneNumber(phoneNum);
                break;
            case 6:
                System.out.println("Your new Bank Account : ");
                String bankAccount = input.nextLine();
                sessionSeller.setSellerBankAccount(bankAccount);
                break;
        }

        sellerDAO.updateSeller(sessionSeller);

    }

    public static void manageSellerNotificationPage() {

        boolean validInput;

        System.out.println("########----- N O T I F I C A T I O N   P A G E-----########");

        ArrayList<Notification> listOfNotificationOfSeller = notificationDAO.getListOfNotificationOfSeller(sessionSeller.getSellerUsername());

        if( listOfNotificationOfSeller != null){

            for (int i = 0; i <listOfNotificationOfSeller.size(); i++) {
                System.out.println(i+1+".   "+"New Order("+listOfNotificationOfSeller.get(i).getNotificationOrderId()+") arrived for "+listOfNotificationOfSeller.get(i).getNotificationProductName()+" from "+listOfNotificationOfSeller.get(i).getNotificationCustomerName());
                listOfNotificationOfSeller.get(i).setNotificationReadOrNot(true);
                notificationDAO.updateNotification(listOfNotificationOfSeller.get(i));
            }
        }else{
            System.out.println("Yay there's no notification to display !");

        }

        System.out.println("You will be now redirected to to Dashboard Page");
        promptEnterKey();
    }


    public static void main(String[] args) {
        sessionCustomer= new Customer();
        sessionCustomer.setUsername("juju");
        cartPage();
        sellerDashboardPage();

        //mainMenuPage();
        //productDisplayPage("iii")     ;
        //ADD SOME TEST DATA TO THE DATABASE


    }
}
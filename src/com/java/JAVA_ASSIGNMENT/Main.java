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


public class Main {

    public static Customer sessionCustomer;
    public static Seller sessionSeller;
    public static Scanner input = new Scanner(System.in);
    static CartDao cartDAO = new CartDaoImp();
    static ProductDao productDAO = new ProductDaoImp();
    static WalletDao walletDAO = new WalletDaoImp();
    static OrderDao orderDAO = new OrdersDaoImp();
    static WalletTransactionDao walletTransactionDAO = new WalletTransactionDaoImp();
    static CustomerDao customerDAO = new CustomerDaoImp();
    static NotificationDao notificationDAO = new NotificationDaoImp();
    static FeedbackDao feedbackDAO = new FeedbackDaoImp();

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

            Customer loginCust = new Customer(inputEmail,inputPassword);
            CustomerDao customerDAO = new CustomerDaoImp();
            customerDAO.loginCustomer(loginCust);

            homePage();
        }else{




            sellerDashboardPage();
        }
        //FOR SELLER
        //1. Get email & password
        //2. Check if this seller is found in the sellerDatabase
        //3. If found then copy to sessionSeller
        //4. Direct to sellerDashboard page
        if(userRole =='S'){
            System.out.print("Enter your email : ");
            inputEmail = input.next();

            System.out.print("Password : ");
            inputPassword = input.next();
            int i;

            Seller loginCust = new Seller(inputEmail,inputPassword);
            SellerDao sellerDAO = new SellerDaoImp();
            sellerDAO.loginSeller(loginCust);
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
        else if (userRole =='S'){
            Seller registerSeller = new Seller(sellerUsername,sellerEmail,sellerPhonenumber,sellerbankaccount,selleraddress,sellerpassword);

            System.out.print("Your Email : ");
            registerSeller.setEmail(input.next());

            System.out.print("Your Password : ");
            registerSeller.setPassword(input.next());

            System.out.print("Your Username : ");
            registerSeller.setUsername(input.next());

            System.out.print("Your Phone Number : ");
            registerSeller.setSellerPhonenumber(input.next());

            System.out.print("Your Address : ");
            registerSeller.setAddress(input.next());

            System.out.print("Your Bank account : ");
            registerSeller.setAddress(input.next());

            SellerDao sellerDAO = new SellerDaoImp();
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
                walletPage();
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



        // Present Options -> 1. Search by Product , 2. Search by Seller
        // Get the choice  [DATA VALIDATION]
        // After validation and checking the choice get the search term
        // Search through the ArrayList of Product , if it matches the search term
        // **Return the results which have similar keywords
        // Then display list of products based on that search term
        // Get user choice of product
        // Then direct Product Display Page

    }

    public static void walletPage() {

        System.out.println("########----- W A L L E T  P A G E-----########");
        WalletDao userWallet = new WalletDaoImp();
        WalletTransactionDao userWalletTransaction = new WalletTransactionDaoImp();

        // Display current balance
        // Present Options -> 1. Top Up Balance , 2.View Transactions , R. Return Home Page
        //-> 1. Top Up Balance    , userWallet.topUpWalletBalance(0.00);
        //-> 2. View Transactions ,  userWalletTransaction.getWalletTransaction()
        //-> R. Return Home Page



        // If user chose to view transactions
        for (int i = 0; i < userWalletTransaction.getWalletTransaction().size(); i++) {
            WalletTransaction printTransaction = userWalletTransaction.getWalletTransaction().get(i);

            System.out.println(
                    printTransaction.getTransactionID() +
                    //printTransaction.getTransactionOrderID() +
                    //printTransaction.getTransactionSellerName() +
                    printTransaction.getTransactionAmount() +
                    printTransaction.getTransactionDateTime()
            );
        }
    }

    public static void cartPage() {


            ArrayList<Cart> cartDetailsOfThisUser = cartDAO.getCart(sessionCustomer.getUsername());


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


    }

    public static void favoritesPage() {

        //using for loop on userFavoritesDatabase
        //display all objects that matches with the current user
        // if no then display necessary message
    }

    public static void categoryPage() {

        //Array of Strings that contains all the categories String categories = {".." , "..."}
        // Display list of Categories // Options -> 1. Men Clothes , 2.Women Clothes.... R.Return
        // Get user choice  [DATA VALIDATION]
        // If the uses chooses to view category
        // Loop all productDatabase that matches the category in the array
        // Search through the ArrayList of Product , if it matches the category
        // Then display list of products based on that category
        // Present Options - 1.View Product 2.Return
        // If the uses chooses to view product
        // Get user choice of product to view a particular product ( pass it to productDisplayPage( String productID) )
        // Then direct Product Display Page


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
                        totalCheckoutAmount,
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
                Notification notificationSeller = new Notification(productsInCartForOrders.getProductSellerUsername(),"OD"+uniqueID,sessionCustomer.getFirstName()+sessionCustomer.getLastName(),productsInCartForOrders.getProductName());
                notificationDAO.addNotification(notificationSeller);

            }


            //Reduce Wallet Balance
            walletDAO.reduceWalletBalance(totalCheckoutAmount);

            //Add Wallet Transaction
            String uniqueID = UUID.randomUUID().toString().substring(0,8);
            WalletTransaction transaction = new WalletTransaction(
                    "TR"+uniqueID ,
                    totalCheckoutAmount,
                    ListofOrdersForTransaction,
                    formattedDate);
            walletTransactionDAO.addWalletTransaction(transaction);

            System.out.println("Payment Successful , you will be now directed to Order History page");

            orderHistoryPage();

        } else {
            System.out.println("You will be now directed to Home page");
        }





    }

    public static void orderHistoryPage() {

        for (int i = 0; i < orderDatabase.size(); i++) {
            //loop thru all the order history and display the list of orders that matches this user
        }

        //If want to view more details
        for (int i = 0; i < orderDatabase.size(); i++) {
            //loop thru all the order history and display the details of the orders that matches the entered ordered id
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

    }


    public static void manageProductPage() {

        ProductDao productDAO = new ProductDaoImp();

        // Find products of this seller
        // View list of products and stock counts
        //Add Product
        //Update product (name ,price and stock counts)
        //Delete product

    }

    public static void manageOrdersPage() {

        //First list all the orders that matches the seller
        for (int i = 0; i < orderDatabase.size(); i++) {

            if (orderDatabase.get(i).getOrderSellerUsername().equals(sessionSeller)) {
                System.out.println(orderDatabase.get(i).getOrderID() + orderDatabase.get(i).getOrderDate() +
                        orderDatabase.get(i).getOrderStatus() + orderDatabase.get(i).getOrderCustomerName() +
                        +orderDatabase.get(i).getOrderTotalPaid());
            }

        }

        // Then Present Options
        // 1.View Details of an Order
        // 2. Return

        //If user chose 1
        // Get the order ID
        // Then display the details
        //Then Present Options -> 1. Would you like to update the order ? 2. Return
        String orderID = "";
        Orders updateOrder = new Orders();
        for (int i = 0; i < orderDatabase.size(); i++) {

            if (orderDatabase.get(i).getOrderID().equals(orderID)) {

                updateOrder = orderDatabase.get(i);

                System.out.println(
                        updateOrder.getOrderID() +
                                updateOrder.getOrderDate() +
                                updateOrder.getOrderStatus() +
                                updateOrder.getOrderCustomerName() +
                                updateOrder.getOrderTotalPaid() +
                                updateOrder.getOrderTrackingID() +
                                updateOrder.getOrderReceivedOrNot()
                );

//                for (int j = 0; j < updateOrder.getOrderCart().size(); j++) {
//                    System.out.println((j + 1) +
//                            updateOrder.getOrderCart().get(j).getCartProduct().getProductName() +
//                            updateOrder.getOrderCart().get(j).getCartProduct().getProductPrice() +
//                            updateOrder.getOrderCart().get(j).getCartQuantity()
//                    );
//                }
            }
        }

        // IF yes , would like to update order
        // Get the tracking ID
        // Once the tracking ID is received the orders status should be changed to Shipping
        updateOrder.setOrderStatus("Shipping");


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

        double totalSellerProfit = 0.0;
        System.out.println("Transaction ID" + "Order ID" + "Payment Date" + "Customer Name" + "Amount Paid");

        for (int i = 0; i < orderDatabase.size(); i++) {

            if (orderDatabase.get(i).getOrderSellerUsername().equals(sessionSeller)) {

                System.out.println(
                        "TR" + (i + 1) + orderDatabase.get(i).getOrderID() +
                                orderDatabase.get(i).getOrderDate() +
                                orderDatabase.get(i).getOrderCustomerName() +
                                orderDatabase.get(i).getOrderTotalPaid());

                totalSellerProfit = orderDatabase.get(i).getOrderTotalPaid();
            }

        }

        System.out.println("Total Profit : " + totalSellerProfit);
        sessionSeller.setSellerProfit(totalSellerProfit);

    }

    public static void manageSellerProfilePage() {

        //View Profile
        // Update necessary attributes
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            String uniqueID = UUID.randomUUID().toString().substring(0,8);
            System.out.println(uniqueID);
        }





//mainMenuPage();
        //productDisplayPage("iii")     ;
        //ADD SOME TEST DATA TO THE DATABASE



    }
}

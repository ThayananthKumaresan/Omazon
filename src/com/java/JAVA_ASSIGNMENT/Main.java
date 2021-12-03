package com.java.JAVA_ASSIGNMENT;


import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.java.JAVA_ASSIGNMENT.CartDaoImp.userCartDatabase;
import static com.java.JAVA_ASSIGNMENT.FavoritesDaoImp.userFavoritesDatabase;
import static com.java.JAVA_ASSIGNMENT.FeedbackDaoImp.feedbackDataBase;
import static com.java.JAVA_ASSIGNMENT.OrdersDaoImp.orderDatabase;
import static com.java.JAVA_ASSIGNMENT.ProductDaoImp.productDatabase;
import static com.java.JAVA_ASSIGNMENT.CustomerDaoImp.customerDatabase;
import static com.java.JAVA_ASSIGNMENT.SellerDaoImp.sellerDatabase;


public class Main {

    public static Customer sessionCustomer;
    public static Seller sessionSeller;
    public static Scanner input = new Scanner(System.in);

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
        do{
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


    }

    public static void logOutPage(char userRole){


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

            //For Seller

        }





    }


    public static void homePage() {

        System.out.println("########----- H O M E  P A G E-----########");

        ProductDao productDAO = new ProductDaoImp();
        ArrayList<Product> top3SellingProducts = productDAO.getTop3SellingProduct();

        // List 3 Best Selling Products ( A , B , C)  getTop3SellingProduct()
        // Present Options ->
        // 1. Search , searchPage()
        // 2. Check Wallet , walletPage()
        // 3. View Cart , cartPage()
        // 4. View Favorites , favoritesPage()
        // 5.View Categories ,   categoryPage()
        // 6. Log Out  logOutPage('C')
        // Get the choice [DATA VALIDATION]

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
                    printTransaction.getTransactionOrderID() +
                    printTransaction.getTransactionSellerName() +
                    printTransaction.getTransactionAmount() +
                    printTransaction.getTransactionDateTime()
            );
        }
    }

    public static void cartPage() {

        // During looping total up the prices and display it as well
        // Present Options -> Press C to Checkout or Press R to return Home Page
        // If C , then redirect to Checkout Page

        ArrayList<Cart> cartDetailsOfThisUser = new ArrayList<>();
        double totalAmount = 0.0;
        for (Cart cart : userCartDatabase) {
            if (cart.getCartUser().equals(sessionCustomer)) {

                Product productsInCartToDisplay;
                productsInCartToDisplay = cart.getCartProduct();
                cartDetailsOfThisUser.add(cart);
                totalAmount += productsInCartToDisplay.getProductPrice();
                System.out.println(productsInCartToDisplay.getProductName() + productsInCartToDisplay.getProductPrice() + cart.getCartQuantity());
            }
        }
        System.out.println("Total Amount in Cart : " + totalAmount);


        //IF choose C for Checkout
        checkoutPage(cartDetailsOfThisUser, totalAmount);

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

        //To display the product , use the product id ,then
        // loop through the productDatabase
        // Display necessary info to the user

        ProductDao productDAO = new ProductDaoImp();
        productDAO.getProduct(productID);

        //Move this logic to getProduct()
        for (int i = 0; i < productDatabase.size(); i++) {
            if (productDatabase.get(i).getProductID().equals(productID)) {
                System.out.println(
                        productDatabase.get(i).getProductName() +
                                productDatabase.get(i).getProductCategory() +
                                productDatabase.get(i).getProductDescription() +
                                productDatabase.get(i).getProductPrice());

            }
            for (int j = 0; j < feedbackDataBase.size(); j++) {

                if (feedbackDataBase.get(i).getFeedbackProduct().equals(productID)) {
                    System.out.println(
                            feedbackDataBase.get(i).getFeedbackReview() +
                                    feedbackDataBase.get(i).getFeedbackCommentBySeller());


                }

            }


        }

//        //Whenever the user chose to add product to cart
//        Cart addToCart = new Cart();
//        Product productForCart = new Product(productSearched.getProductID(), productSearched.getProductName(), productSearched.getProductDescription(), productSearched.getProductPrice());
//        userCartDatabase.add(addToCart);
//
//
//        //Whenever the user chose to add product to favorites
//        Product productForFavorites = new Product(productSearched.getProductID(), productSearched.getProductName(), productSearched.getProductDescription(), productSearched.getProductPrice());
//        Favorites addToFavorites = new Favorites(productForFavorites, "Username");
//        userFavoritesDatabase.add(addToFavorites);


    }


    public static void checkoutPage(ArrayList<Cart> cartDetailsOfThisUser, double totalCheckoutAmount) {

        //using for loop on userCartDatabase
        //display list of products,price that matches with the current user

        for (int i = 0; i < cartDetailsOfThisUser.size(); i++) {

            System.out.println(
                    cartDetailsOfThisUser.get(i).getCartProduct().getProductName() +
                            cartDetailsOfThisUser.get(i).getCartProduct().getProductPrice() +
                            cartDetailsOfThisUser.get(i).getCartQuantity());

        }
        System.out.println("Total Amount to Checkout : " + totalCheckoutAmount);


        //Add Transaction
        WalletTransaction transaction = new WalletTransaction("T1001", 30.00, "Muhadiyyah", "OD0392", new Date());
        WalletTransactionDao userWalletTransaction = new WalletTransactionDaoImp();
        userWalletTransaction.addWalletTransaction(transaction);


        //Reduce Wallet Balance
        WalletDao userWallet = new WalletDaoImp();
        userWallet.updateWalletBalance(totalCheckoutAmount);

        //Add New Order
        Orders order = new Orders();
        orderDatabase.add(order);

        //Update Product StockCount
        for (int j = 0; j < cartDetailsOfThisUser.size(); j++) {

            for (int i = 0; i < productDatabase.size(); i++) {

                if (cartDetailsOfThisUser.get(i).getCartProduct().getProductID().equals(productDatabase.get(i).getProductID())) {
                    productDatabase.get(i).setProductStockCount(productDatabase.get(i).getProductStockCount() - cartDetailsOfThisUser.get(i).getCartQuantity());
                }
            }

            //TODO : Removing from Cart Database
            userCartDatabase.remove(cartDetailsOfThisUser.get(j));

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
        // Present Options -> 1. Change Username , 2.Change Email  , 3.Change Password , 4.Update address , 5.Delete Account
        // Get the choice [DATA VALIDATION]
        // Perform the action accordingly

    }

    public static void exitApp() {

    }


    public static void sellerDashboardPage() {

    }


    public static void manageProductPage() {
        // every object of projectDoa should point to same database???
        ProductDaoImp productDao = new ProductDaoImp();

        // get a list of seller product from ProjectDoa
        Product[] product = sessionSeller.getSellerProduct();

        // View list of products and stock counts
        System.out.println("Prosuct ID     Name           Category       Price          Stock");
        for (int i = 0; i < product.length; i++){
            System.out.printf("%15s%15s%15s%15s%15s\n", product[i].getProductID(), product[i].getProductCategory(), product[i].getProductName()
            , product[i].getProductPrice(), product[i].getProductStockCount());
        }

        do{
            System.out.println("(1) for add product\n(2) for update product\n(3) for delete product\n(4) for exit");
            System.out.println("Enter command:");

            //Get input of a whole line and take the frist character
            String inpuString = input.nextLine();
            switch(inpuString.charAt(0)){
                case '1':
                    //Add Product
                    addProductPage();
                    break;
                case '2':
                    //Update product (name ,price and stock counts)
                    updateProductPage();
                    break;
                case '3':
                    //Delete product
                    deleteProductPage();
                    break;
                case '4':
                    System.out.println("Exit from seller product page...");
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }while (true);
    }

    public static void addProductPage(){
        ProductDaoImp productDao = new ProductDaoImp();

        //Generate product id, SHOULD HAVE A METHOD IN ProductDOA DO THIS
        String productID = productDao.generateID();

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
        productDao.addProduct(new Product(productID, name, descrip, category, sessionSeller.getSellerUsername(),price, stock, 0));

        System.out.println("Successfully add product");
    }

    public static void updateProductPage(){
        ProductDaoImp productDao = new ProductDaoImp();

        System.out.print("Enter the id of product:");
        String id = input.next();

        //get the list of product
        Product[] list = sessionSeller.getSellerProduct();

        //find the product with the id
        Product product = null; 
        for (int i = 0; i < list.length; i++){
            if(list[i].getProductID() == id)
                product = list[i];
        }
        //if not find the id,return
        if(product == null){
            System.out.println("Product not find");
            return;
        }

        do{
            System.out.println("(1) for update name\n(2) for description\n(3) for category\n(4) for stock(5) for price\n(6) for exit");
            
            //Get input of a whole line and take the frist character
            String inputString = input.nextLine();
            System.out.println("Enter:");
            switch(inputString.charAt(0)){
                //using next line to enable space between word
                case '1':
                    product.setProductName(input.nextLine());
                    productDao.updateProduct(product);
                    break;
                case '2':
                    product.setProductDescription(input.nextLine());
                    productDao.updateProduct(product);
                    break;
                case '3':
                    product.setProductCategory(input.nextLine());
                    productDao.updateProduct(product);
                    break;
                case '4':
                    product.setProductStockCount(input.nextInt());
                    productDao.updateProduct(product);
                    break;
                case '5':
                    product.setProductPrice(input.nextDouble());
                    productDao.updateProduct(product);
                    break;
                case '6':
                    return;
                default:
                    System.out.println("Invalid input");
                
            }

        }while (true);
        
    }

    public static void deleteProductPage(){
        ProductDaoImp productDao = new ProductDaoImp();

        System.out.print("Enter the id of product:");
        String id = input.next();

        //get the list of product
        Product[] list = sessionSeller.getSellerProduct();

        //find the product with the id and delete it
        for (int i = 0; i < list.length; i++){
            if(list[i].getProductID() == id){
                productDao.deleteProduct(list[i]);
                System.out.println("Sucessfully delete product");
                return;
            }
        }
        System.out.println("Object not found");
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

                for (int j = 0; j < updateOrder.getOrderCart().size(); j++) {
                    System.out.println((j + 1) +
                            updateOrder.getOrderCart().get(j).getCartProduct().getProductName() +
                            updateOrder.getOrderCart().get(j).getCartProduct().getProductPrice() +
                            updateOrder.getOrderCart().get(j).getCartQuantity()
                    );
                }
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


        mainMenuPage();



    }
}
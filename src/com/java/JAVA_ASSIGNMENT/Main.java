package com.java.JAVA_ASSIGNMENT;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {

    public static Customer sessionCustomer = new Customer();
    public static Seller sessionSeller = new Seller();
    public static Scanner input = new Scanner(System.in);
    static CartDao cartDAO = new CartDaoImp();
    static ProductDao productDAO = new ProductDaoImp();
    static WalletDao walletDAO = new WalletDaoImp();
    static OrdersDao ordersDAO = new OrdersDaoImp();
    static TransactionDao transactionDAO = new TransactionDaoImp();
    static CustomerDao customerDAO = new CustomerDaoImp();
    static SellerDao sellerDAO = new SellerDaoImp();
    static NotificationDao notificationDAO = new NotificationDaoImp();
    static FeedbackDao feedbackDAO = new FeedbackDaoImp();
    static FavoritesDao favoriteDAO = new FavoritesDaoImp();
static DecimalFormat df = new DecimalFormat("0.00");
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");


    public static void promptEnterKey() {
        System.out.println("Press \"ENTER\" to return...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public static void clrScr() {
        for (int i = 0; i < 5; ++i) System.out.println();

    }

    public static void mainMenuPage() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ OMAZON ONLINE SHOPPING APP ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("Welcome digital nomads. We know how important Omazon is in your life to survive this pandemic.");
        System.out.println("But ... first , tell us who you are or press E to exit system");

        System.out.println("S. Seller and I'm going to sell great products! ");
        System.out.println("C. Customer and I cant wait to buy ! ");
        System.out.println("E. Exit system ");

        char userRole ;
        boolean validInput;
        do {  //
            System.out.print("\nYour option ? : ");
            userRole = input.next().charAt(0);

            if (userRole == 'S' || userRole == 'C'  || userRole == 'E') {
                validInput = true;
            } else {
                System.out.print("Oops wrong value, please enter either S / C or E.");
                validInput = false;
            }
        } while (!validInput);


        if (userRole == 'S' || userRole == 'C')
        {
            System.out.println("Before showing your shopping ability , please choose to ");
            System.out.println("1. Login");
            System.out.println("2. Register");

            int userChoice = 0;
            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 2) {
                        System.out.print("Oops wrong value, please enter either 1 or 2 only.");
                        validInput = false;
                        input.nextLine();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

            } while (!validInput);


            if (userRole == 'S') {

                if (userChoice != 1) {
                    registerPage('S');
                }
                loginPage('S');

            } else {

                if (userChoice != 1) {
                    registerPage('C');
                }
                loginPage('C');
            }

        }else{
            exitSystem();
        }


    }

    public static void loginPage(char userRole) {


        System.out.println("########----- L O G I N  P A G E-----########");

        String inputEmail;
        String inputPassword ;


        // FOR CUSTOMER
        //1. Get email & password , then create an instance of user and set email and password
        //2. Check if this customer is found in the customerDatabase
        //3. If found then copy to sessionCustomer
        //4. Redirect user to  Home Page
        if (userRole == 'C') {
            Customer loginCustomer;
            do {
                System.out.print("Your email : ");
                inputEmail = input.next();

                System.out.print("Your Password : ");
                inputPassword = input.next();

                loginCustomer = new Customer(inputEmail, inputPassword);

            } while (!customerDAO.loginCustomer(loginCustomer));


            homePage();
        } else {

            Seller loginSeller ;
            do {
                System.out.print("Enter your email : ");
                inputEmail = input.next();

                System.out.print("Password : ");
                inputPassword = input.next();

                loginSeller = new Seller(inputEmail, inputPassword);

            } while (!sellerDAO.loginSeller(loginSeller));

            sellerDashboardPage();
        }

    }

    public static void logOutPage(char userRole) {

        if (userRole == 'C') {
            System.out.print("Thank you for shopping. You have been logged out. You will be now redirected to Main Menu Page");
            sessionCustomer = null;
        } else {
            System.out.print("Thank you for your service. You have been logged out.You will be now redirected to Main Menu Page");
            sessionSeller = null;
        }

        promptEnterKey();
        mainMenuPage();

    }


    public static void registerPage(char userRole) {

        System.out.println("########----- R E G I S T R A T I O N  P A G E-----########");

        String inputEmail ;

        if (userRole == 'C') {
            Customer registerCustomer = new Customer();

            System.out.print("Your Email : ");
            inputEmail = input.next();
            //Perform Data validation for email , then only set it
            registerCustomer.setEmail(inputEmail);

            System.out.print("Your Password : ");
            registerCustomer.setPassword(input.next());
            System.out.print("Your Username : ");
            registerCustomer.setUserName(input.next());
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
        } else {

            Seller registerSeller = new Seller();

            System.out.print("Your Email : ");
            registerSeller.setEmail(input.next());

            System.out.print("Your Password : ");
            registerSeller.setPassword(input.next());

            System.out.print("Your Username : ");
            registerSeller.setUserName(input.next());

            System.out.print("Your First Name : ");
            registerSeller.setFirstName(input.next());

            System.out.print("Your Last Name : ");
            registerSeller.setLastName(input.next());

            System.out.print("Your IC Number : ");
            registerSeller.setSellerIC(input.next());

            System.out.print("Your Phone Number : ");
            registerSeller.setSellerPhoneNumber(input.next());

            System.out.print("Your Address : ");
            registerSeller.setSellerAddress(input.next());

            System.out.print("Your Shop Name : ");
            registerSeller.setSellerShopName(input.next());

            System.out.print("Your Business Registration Number : ");
            registerSeller.setSellerBusinessRegistrationNumber(input.next());

            //TODO : DO WE NEED THIS ?
            System.out.print("Your Bank Account : ");
            registerSeller.setSellerBankAccount(input.next());

            sellerDAO.registerSeller(registerSeller);
        }


    }


    public static void homePage() {

        boolean returnToDashboard = true;
        int userChoice = 0;

        do {
            System.out.println("\n\n########----- H O M E  P A G E-----########");

            ProductDao productDAO = new ProductDaoImp();
            ArrayList<Product> top3SellingProducts = productDAO.getTop3SellingProduct();
            System.out.println("TOP SELLING PRODUCTS");
            for (int i = 0; i < top3SellingProducts.size(); i++)
                System.out.println("NO." + (i + 1) + " - " + "Product ID = "+ top3SellingProducts.get(i).getProductID()+ " Product Name = "+top3SellingProducts.get(i).getProductName());

            System.out.println("\n1.Search Page");
            System.out.println("2.Check Wallet");
            System.out.println("3.View Cart");
            System.out.println("4.View Favorites");
            System.out.println("5.View Categories");
            System.out.println("6.View details of a product from Top Selling List");
            System.out.println("7.Order History");
            System.out.println("8.Profile Page");
            System.out.println("9.Log Out");


            boolean validInput;

            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 9) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 or 9 only.");
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
                    searchPage();
                    break;
                case 2:
                    walletPage();
                    break;
                case 3:
                    cartPage();
                    break;
                case 4:
                    favoritesPage();
                    break;
                case 5:
                    categoryPage();
                    break;
                case 6:
                    int productID=0;

                    do {
                        try {
                            System.out.print("\nEnter product ID to view details of the product :");
                            productID = input.nextInt();
                            validInput = true;

                            if (productID != top3SellingProducts.get(0).getProductID() && productID != top3SellingProducts.get(1).getProductID() && productID != top3SellingProducts.get(2).getProductID() ) {
                                System.out.print("Oops you entered have entered an invalid ID ,  please only enter products ID's that can be found in the list above.");
                                validInput = false;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have entered an invalid format of input");
                            validInput = false;
                            input.nextLine();
                        }

                    } while (!validInput);

                    productDisplayPage(productID);

                    break;
                case 7: orderHistoryPage();
                    break;
                case 8: userProfilePage();
                    break;

                case 9:
                    returnToDashboard = false;
                    break;

            }
        } while (returnToDashboard);

        System.out.println("You will be now logged out ....");
        logOutPage('C');

    }

    public static void searchPage() {


        //result of searching similar term
        ArrayList<Product> searchResult = new ArrayList<>();
        // require a method in class ProductDao to return an ArrayList contain all Product in database, will raise as an issue
        ArrayList<Product> listOfAllProducts = productDAO.getListOfAllProduct();

        int cont = 0;

        do {
            System.out.println("\n########----- S E A R C H  P A G E-----########");
            System.out.print("1. Search by product\n2. Search by seller\n3. Return ");

            int userChoice = 0;
            boolean validInput;

            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    input.nextLine();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 3) {
                        System.out.print("Oops wrong value, please enter either 1 or 2 only.");
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

                // TODO : THE SEARCH DOESN'T RETURN RELEVANT TERMS
                // After validation and checking the choice get the search term
                case 1:
                    System.out.print("Enter your search term  : ");
                    String term = input.nextLine();
                    for (int i = 0; i < listOfAllProducts.size(); i++) {
                        Product temp = listOfAllProducts.get(i);
                        //check does name of product contain term or term contain name of product
                        if (temp.getProductName().contains(term) || term.contains(temp.getProductName()))
                            searchResult.add(temp);  //if true,add product into arrayList searchResult
                    }
                    break;
                case 2:
                    System.out.print("Enter your search term  : ");
                    term = input.nextLine();
                    for (int i = 0; i < listOfAllProducts.size(); i++) {
                        Product temp = listOfAllProducts.get(i);
                        // check does name of seller contain term or term contain name of seller
                        // don't use function getListOfThisSeller
                        // to enable user input Tan , seller Tan Chun Hong and James Tan came out(two different seller)
                        if (productDAO.getProductSellerUsername(temp.getProductID()).contains(term) || term.contains(productDAO.getProductSellerUsername(temp.getProductID())))
                            searchResult.add(temp);

                    }
                    break;
                case 3:
                    promptEnterKey();
                    cont = 0;
                    break;
            }

            if (userChoice == 1 || userChoice == 2) {

                if (searchResult.size() == 0) {

                    System.out.println("Oops nothing found , please enter a correct a term");
                    System.out.println("\nWould you like to continue search or return ? \n1. To continue search \n2. To Return");

                    do {
                        try {
                            System.out.print("\nYour option : ");
                            cont = input.nextInt();
                            validInput = true;

                            if (cont < 1 || cont > 2) {
                                System.out.print("Oops wrong value, please enter either 1 or 2 only.");
                                validInput = false;
                                input.nextLine();
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have entered an invalid format of input");
                            validInput = false;
                            input.nextLine();
                        }

                    } while (!validInput);

                } else {
                    System.out.println("Product ID     Name           Category       Price");
                    for (Product product : searchResult)
                        System.out.printf("%-15.15s%-15.15s%-15.15s%-15.2f\n",
                                product.getProductID(),
                                product.getProductName(),
                                product.getProductCategory(),
                                product.getProductPrice());

                    System.out.println("\nWhat would you like to do ? ");
                    System.out.println("1. View Details of an product");
                    System.out.println("2. Return");

                    do {
                        try {
                            System.out.print("\nYour option : ");
                            userChoice = input.nextInt();
                            validInput = true;

                            if (userChoice < 1 || userChoice > 2) {
                                System.out.print("Oops wrong value, please enter either 1 or 2 only.");
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

                        System.out.print("Enter product ID to view details of the product :");
                        productDisplayPage(input.nextInt());
                    }
                    cont = 1;

                }
            }

        } while (cont == 1);

        // Search through the ArrayList of Product , if it matches the search term
        // Test and  get the size of listOfAllProducts outside the loop to improve performance
        // *Focus on for loop to improve performance
        // The code has linear order of grow for size of listOfAllProducts,may slow if listOfAllProducts contain too many element
        // ***Don't use the code with listOfAllProducts with too many element like more than ten thousand
        // Now the arraylistOfAllProducts searchResult contain the results which have similar keywords
        // Then display listOfAllProducts of products based on that search term

    }


    public static void walletPage() {

        boolean redirectToTopFlag = true;
        do {
            System.out.println("\n\n########----- W A L L E T  P A G E-----########");

            int userChoice = 0;
            boolean validInput ;

            // Display current balance
            System.out.print("Current Balance : RM ");
            System.out.println(df.format(sessionCustomer.getUserWallet().getWalletBalance()));

            System.out.println("\n1. Top Up Balance");
            System.out.println("2. View Transaction");
            System.out.println("3. Return to Home Page");


            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 3) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 or 3 only.");
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
                    System.out.print("Enter the amount to top up : RM ");
                    walletDAO.topUpWalletBalance(sessionCustomer.getUserWallet(), input.nextDouble());
                    System.out.print("Top up Successful !!!");
                    break;

                case 2:
                    if (sessionCustomer.getUserWallet().getWalletTransaction() == null) {
                        System.out.println("Oops no transaction yet ! ");
                    } else {
                        System.out.println("No      Transaction ID        Amount       Date & Time");
                        for (int i = 0; i < sessionCustomer.getUserWallet().getWalletTransaction().size(); i++) {
                            Transaction printTransaction = sessionCustomer.getUserWallet().getWalletTransaction().get(i);
                            System.out.print(i + 1 + "      ");
                            System.out.print("TR"+printTransaction.getTransactionID() + "                    ");
                            //TODO FORMAT PRINTING HERE
                            System.out.println(
                                    "RM "+ printTransaction.getTransactionAmount() + "     "+
                                    printTransaction.getTransactionDateTime()
                            );
                        }
                    }
                    break;
                case 3:
                    promptEnterKey();
                    redirectToTopFlag = false;
                    break;
            }


        } while (redirectToTopFlag);


    }


    public static void cartPage() {


        System.out.println("\n########----- C A R T  P A G E-----########");

        ArrayList<Cart> listOfCartOfThisCustomer = cartDAO.getListOfCartOfThisCustomer(sessionCustomer.getCustomerID());

        if (listOfCartOfThisCustomer != null) {
            double totalAmount = 0.0;

            System.out.println("No      Product Name        Price       Quantity");
            for (int i = 0; i < listOfCartOfThisCustomer.size(); i++) {

                Cart cart = listOfCartOfThisCustomer.get(i);
                Product productsInCartToDisplay = productDAO.getProduct(cart.getCartProductID());

                System.out.println((i + 1) + "       " +
                        productsInCartToDisplay.getProductName() + "      "
                        + "RM " + productsInCartToDisplay.getProductPrice() + "      " +
                        cart.getCartQuantity());

                totalAmount += productsInCartToDisplay.getProductPrice() * cart.getCartQuantity();

            }

            System.out.printf("\n\nTotal Amount in Cart : RM %.2f", totalAmount);
            System.out.println("\n\nWhat would you like to do ?");
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
                System.out.println("\nYou will be now directed to Checkout page");
                checkoutPage(listOfCartOfThisCustomer, totalAmount);

            }
        } else {
            System.out.println("\nOops , there is no products in your cart. Please add products in your cart !");

        }
        System.out.println("\n\nYou will be now directed to Home page");
        promptEnterKey();

    }

    public static void favoritesPage() {

        System.out.println("\n########----- F A V O R I T E S   P A G E-----########");

        ArrayList<Favorites> listOfFavorites = favoriteDAO.getListOfFavorites(sessionCustomer.getCustomerID());

        if (listOfFavorites != null) {

            System.out.println("No      Product Name        Price ");
            for (int i = 0; i < listOfFavorites.size(); i++) {

                Favorites favorite = listOfFavorites.get(i);

                System.out.println((i + 1) + "      " +
                        productDAO.getProduct(favorite.getFavoritesProductID()).getProductName() + "      " +
                        productDAO.getProduct(favorite.getFavoritesProductID()).getProductPrice());
            }

        } else {
            System.out.println("\nOops sorry , no products added to your favorites");
        }

        System.out.println("\n\nYou will be now redirected to to Home Page");
        promptEnterKey();
    }

    public static void categoryPage() {

        boolean cont = false;
        do{
            System.out.println("########----- C A T E G O R Y   P A G E-----########");

            //Array of Strings that contains all the categories String categories = {".." , "..."}
            String[] category = new String[]{"Women Clothes", "Men Clothes", "Health & Beauty", "Mobile & Accessories",
                    "Baby & Toys", "Watches", "Home & Living", "Home Appliances", "Women's Bags", "Men's Bags & Wallets",
                    "Muslim Fashion", "Computer & Accessories", "Groceries & Pets", "Sport & Outdoor", "Women Shoes",
                    "Men Shoes", "Fashion Accessories", "Games, Books & Hobbies", "Automotive", "Tickets & Vouchers"};


            // Display list of Categories // Options -> 1. Men Clothes , 2.Women Clothes.... R.Return
            System.out.println("Category ID    Category Name");
            for (int i = 0; i < category.length; i++) {
                System.out.println(i + 1 + "            "+category[i]);
            }


            // Get user choice  [DATA VALIDATION]
            int userChoice = 0;
            boolean validInput;

            System.out.println("\n\nWhat would you like to do ?");
            System.out.println("1. Choose a category to view the products");
            System.out.println("2. Return to Home");

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

                System.out.print("Type the Category ID : ");
                int categoryNo = input.nextInt();

                ArrayList<Product> listOfProductsBasedOnCategory = productDAO.getListOfProductsBasedOnCategory(category[categoryNo-1]);

                if (listOfProductsBasedOnCategory != null) {

                    System.out.println("\n\nList of Products in " + category[categoryNo-1]);
                    System.out.println("Product ID    Product Name");

                    for (Product product : listOfProductsBasedOnCategory) {
                        System.out.println(product.getProductID() + "             " + product.getProductName());
                    }

                    System.out.println("\n\nWhat would you like to do ?");
                    System.out.println("1. View a product");
                    System.out.println("2. Return   ");

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
                        System.out.print("Type the Product ID : ");
                        int productID = input.nextInt();
                        productDisplayPage(productID);

                    } else {
                         cont=true;
                    }
                } else {
                    System.out.println("\nOops sorry , no products yet. They're on the way");
                }


            } else {
                cont=false;

            }

        }while(cont);
        System.out.println("\n\nYou will be now redirected to to Home Page");
        promptEnterKey();

    }

    public static void productDisplayPage(int productID) {


        System.out.println("\n########----- P R O D U C T  P A G E-----########");

        Product searchedProduct = productDAO.getProduct(productID);
        if (searchedProduct != null) {

            System.out.println(
                    "\n\nProduct Name : " + searchedProduct.getProductName() + "\n" +
                            "Product Category :  " + searchedProduct.getProductCategory() + "\n" +
                            "Product Price : RM " + searchedProduct.getProductPrice() + "\n" +
                            "Stock Available : " + searchedProduct.getProductStockCount());
            if (searchedProduct.getProductSalesCount() == 0) {
                System.out.println("Sold Quantity : No Sales Yet");
                System.out.println("Product Rating : No rating yet");
            } else {
                System.out.println("Product Rating : " + feedbackDAO.getAverageRatingOfThisProduct(productID));
                System.out.println("Sold Quantity : " + searchedProduct.getProductSalesCount());
            }

            System.out.println("Product Description : " + searchedProduct.getProductDescription());
            System.out.println("Product Reviews : ");
            ArrayList<Feedback> searchedProductFeedback = feedbackDAO.getListOfFeedbackOfThisProduct(productID);

            if (searchedProductFeedback != null) {
                for (Feedback feedback : searchedProductFeedback) {
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println(
                            "User " + customerDAO.getCustomerUsername(feedback.getFeedbackCustomerID()) + ": " + feedback.getFeedbackReview() +
                            "\nComment By Seller : " + feedback.getFeedbackCommentBySeller()
                    );
                    System.out.println("------------------------------------------------------------------------------------");

                }
            } else {
                System.out.println("No Reviews yet :(");

            }

            boolean sameSeller = false;
            if(sessionSeller.getSellerID() == searchedProduct.getProductSellerID()){
                System.out.println("\nWhat would you like to do ?");
                System.out.println("1. Add to favorites");
                System.out.println("2. Return");
                sameSeller = true;
            }
            else{
                System.out.println("\nWhat would you like to do ?");
                System.out.println("1. Add to cart");
                System.out.println("2. Add to favorites");
                System.out.println("3. Return");
            }

            int userChoice = 0, cartQuantity = 0;
            boolean validInput;

            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (sameSeller && (userChoice < 1 || userChoice > 2)){
                        System.out.print("Oops wrong value, please enter either 1 or 2.");
                        validInput = false;
                        input.nextLine();
                    }
                    else if (userChoice < 1 || userChoice > 3) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 or 3.");
                        validInput = false;
                        input.nextLine();
                    }
            
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

                if(sameSeller)
                    userChoice++;
            } while (!validInput);


            if (userChoice == 1) {

                do {
                    try {
                        System.out.print("\nEnter quantity in digits (Eg :25) :");
                        cartQuantity = input.nextInt();
                        validInput = true;

                    } catch (InputMismatchException ex) {
                        System.out.println("You have entered an invalid format of input");
                        validInput = false;
                        input.nextLine();
                    }

                    Cart addToCart = new Cart(productID, cartQuantity, sessionCustomer.getCustomerID());
                    cartDAO.addCart(addToCart);

                    System.out.println("Great this product is added to cart with the quantity " + cartQuantity);
                    System.out.println("You will be now directed to Home Page ");

                    promptEnterKey();
                } while (!validInput);

            } else if (userChoice == 2) {

                Favorites addToFavorites = new Favorites(searchedProduct.getProductID(), sessionCustomer.getCustomerID());
                favoriteDAO.addFavorites(addToFavorites);
                System.out.println("Great this product is added to favorites !");
                System.out.println("You will be redirected to Home Page");
                promptEnterKey();

            } else {
                System.out.println("You will be redirected to Home Page");
                promptEnterKey();
            }

        } else {

            System.out.println("Oops sorry couldn't find the product you're looking for. Please enter the product ID correctly");
        }


    }


    public static void checkoutPage(ArrayList<Cart> listOfCartOfThisCustomer, double totalCheckoutAmount) {

        System.out.println("\n########----- C H E C K O U T   P A G E-----########");

        // todo : shipping fees
        for (int i = 0; i < listOfCartOfThisCustomer.size(); i++) {

            Cart cart = listOfCartOfThisCustomer.get(i);
            Product productsInCartToDisplay = productDAO.getProduct(cart.getCartProductID());
            System.out.println((i + 1) + "      " +
                    productsInCartToDisplay.getProductName() + "      " +
                    productsInCartToDisplay.getProductPrice() + "      " +
                    cart.getCartQuantity());
        }
        System.out.println("\n\nTotal Amount to Checkout : RM " + df.format(totalCheckoutAmount));

        System.out.println("\n\nWhat would you like to do ?");
        System.out.println("1. Pay Now");
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

            String paymentPassword;
            do {
                System.out.print("Enter your payment password : ");
                paymentPassword = input.next();

                if (!customerDAO.checkPaymentPassword(paymentPassword)) {
                    System.out.println("Uh Oh , wrong password. Try again:");
                }

            } while (!customerDAO.checkPaymentPassword(paymentPassword));

            // This loop is to make sure there is sufficient balance to make the transaction
            while (sessionCustomer.getUserWallet().getWalletBalance() < totalCheckoutAmount) {

                System.out.println("\nInsufficient Balance , please Top Up. Your balance in wallet is RM " + df.format(sessionCustomer.getUserWallet().getWalletBalance()));
                System.out.println("\n\nWhat would you like to do ?");
                System.out.println("1. Top Up my Wallet and Proceed Payment");
                System.out.println("2. Cancel this transaction");

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
                    //TODO: Input Validation
                    System.out.print("Enter the amount you would like to top up : RM ");
                    double topUpAmount = input.nextDouble();
                    walletDAO.topUpWalletBalance(sessionCustomer.getUserWallet(), topUpAmount);

                } else {
                    break;
                }

            }

            if(userChoice ==1){
                //Once there is Sufficient balance , proceed the checkout process
                LocalDateTime myDateObj = LocalDateTime.now();
                String formattedDate = myDateObj.format(myFormatObj);

                //Add New Order
                //  ArrayList<Orders> listOfOrdersForTransaction = new ArrayList<>();

                for (Cart cart : listOfCartOfThisCustomer) {

                    Product productsInCartForOrders = productDAO.getProduct(cart.getCartProductID());

                    Orders order = new Orders(
                            "Unprocessed",
                            formattedDate,
                            sessionCustomer.getCustomerID(),
                            false,
                            "Track Not Set",
                            false,
                            productsInCartForOrders.getProductSellerID(),
                            productsInCartForOrders.getProductID(),
                            cart.getCartQuantity()
                    );
                    // Add Orders
                    // listOfOrdersForTransaction.add(order);
                    ordersDAO.addOrders(order);

                    //Increase Sales Count of this product
                    productDAO.reduceProductStock(productsInCartForOrders, cart.getCartQuantity());

                    //Reduce Stock Count of this product
                    productDAO.addProductSalesCount(productsInCartForOrders, cart.getCartQuantity());

                    //Removing from user's cart
                    cartDAO.deleteCart(cart.getCartID());

                    // Notify the seller
                    Notification notificationSeller = new Notification(productsInCartForOrders.getProductSellerID(), order.getOrderID(), sessionCustomer.getCustomerID(), productsInCartForOrders.getProductID());
                    notificationDAO.addNotification(notificationSeller);

                    // TODO : ADD CUSTOMER/SELLER FLAG
                    // Add transaction for seller
                    Transaction transaction = new Transaction(
                            productsInCartForOrders.getProductPrice()*cart.getCartQuantity(),
                            formattedDate,
                            productsInCartForOrders.getProductSellerID());
                    transactionDAO.addTransaction(transaction);

                    sellerDAO.updateSellerProfit(productsInCartForOrders.getProductSellerID(), productsInCartForOrders.getProductPrice()*cart.getCartQuantity());

                }


                //Reduce Wallet Balance
                walletDAO.reduceWalletBalance(sessionCustomer.getUserWallet(), totalCheckoutAmount);

                // Add transaction for customer
                Transaction transaction = new Transaction(
                        totalCheckoutAmount,
                        formattedDate,
                        sessionCustomer.getCustomerID()
                );
                transactionDAO.addTransaction(transaction);

                System.out.println("Payment Successful , you will be now directed to Order History page");

                orderHistoryPage();
            }


        }


    }

    public static void orderHistoryPage() {

            System.out.println("\n\n########----- ORDER HISTORY  PAGE-----########");

            ArrayList<Orders> listOfOrders = ordersDAO.getListOfOrdersOfCustomer(sessionCustomer.getCustomerID());
            if(  listOfOrders != null  ){
                System.out.println("No      Order ID    Order Date      Product Name       Order Status       Seller Username");

                for (int i = 0; i < listOfOrders.size(); i++) {
                    System.out.println((i + 1) + "       " +
                            listOfOrders.get(i).getOrderID() + "           " +
                            listOfOrders.get(i).getOrderDate() + "      " +
                            productDAO.getProduct(listOfOrders.get(i).getOrderProductID()).getProductName() + "      " +
                            listOfOrders.get(i).getOrderStatus() + "      " +
                            sellerDAO.getSellerUsername(listOfOrders.get(i).getOrderSellerID()));
                }

                System.out.println("\n1. View details of an Order");
                System.out.println("2. Return to home page");
                int userChoice =0;         // Get the choice

                boolean validInput;
                do {
                    try {
                        System.out.print("\nYour option : ");
                        userChoice = input.nextInt();
                        validInput = true;

                        if (userChoice < 1 || userChoice > 2) {
                            System.out.print("Oops wrong value, please enter either 1 or 2 only.");
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

                    Orders order = null;
                    //If we want to view more details
                    do {
                        try {
                            System.out.print("Enter the Order ID to view the details : ");
                            int orderID = input.nextInt();
                            order = ordersDAO.getOrders(orderID);
                            validInput = true;

                            if (order == null) {
                                System.out.println("Uh oh , you have entered wrong Order ID, please only enter from the list above. ");
                                validInput = false;
                                input.nextLine();
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have entered an invalid format of input");
                            validInput = false;
                            input.nextLine();
                        }

                    } while (!validInput);

                     System.out.println(
                                        "Order ID     : " + order.getOrderID() + "\n" +
                                        "Order Date   : " + order.getOrderDate() + "\n" +
                                        "Order Status : " + order.getOrderStatus() + "\n" +
                                        "Product Name : " + productDAO.getProduct(order.getOrderProductID()).getProductName() + "\n" +
                                        "Product Price    : " + productDAO.getProduct(order.getOrderProductID()).getProductPrice() + "\n" +
                                        "Quantity Ordered : " + order.getOrderQuantity());

                        if (order.getOrderStatus().equals("Processing / Shipping")) {
                            System.out.println("Tracking ID : " + order.getOrderTrackingID() + "\n");
                            System.out.println("Please update the Delivery of this Order");

                            char orderReceivedConfirmation = 0;
                            do {
                                try {
                                    System.out.print("\nHave you received the order ? Y = Yes or N = No : ");
                                     orderReceivedConfirmation = input.next().charAt(0);
                                    validInput = true;

                                    if (orderReceivedConfirmation !='Y' && orderReceivedConfirmation !='N') {
                                        System.out.print("Oops wrong value, please enter either Y or N only.");
                                        validInput = false;
                                        input.nextLine();
                                    }
                                } catch (InputMismatchException ex) {
                                    System.out.println("You have entered an invalid format of input.");
                                    validInput = false;
                                    input.nextLine();
                                }

                            } while (!validInput);



                            if (orderReceivedConfirmation == 'Y') {
                                System.out.println("Thank you for your confirmation !");

                                order.setOrderStatus("Delivered");
                                order.setOrderReceivedOrNot(true);
                                ordersDAO.updateOrders(order);

                                System.out.println("\nPlease rate this order from 1 - 5 ! ");
                                int prodRating = 0;

                                do {
                                    try {
                                        System.out.print("Your Rating : ");
                                        prodRating = input.nextInt();
                                        input.nextLine();
                                        validInput = true;

                                        if (prodRating < 1 || prodRating > 5) {
                                            System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 or 5 only.\n");
                                            validInput = false;
                                        }

                                    } catch (InputMismatchException ex) {
                                        System.out.println("You have entered an invalid format of input");
                                        validInput = false;
                                        input.nextLine();
                                    }

                                } while (!validInput);

                                System.out.println("\nPlease leave your feedback : ");
                                String productFeedback = input.nextLine();


                                //TODO : TO THINK WHETHER THIS COMES EARLIER OR NOT
                                Feedback feedbackProduct = new Feedback(
                                        productDAO.getProduct(order.getOrderProductID()).getProductID(),
                                        productFeedback,
                                        "None",
                                        sessionCustomer.getCustomerID(),
                                        prodRating);

                                feedbackDAO.addFeedback(feedbackProduct);
                            }

                        } else if (order.getOrderStatus().equals("Unprocessed")) {
                            System.out.println("\nYour order is yet to be processed by the seller");
                        }

                }

            }
            else{
                System.out.println("\nThere is no orders have been placed !");

            }

        System.out.println("\n\nYou will be redirected to Home Page");
        promptEnterKey();


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
        int deleteConfirmation = 0;
        boolean redirectToTopFlag = true;

        do{

            System.out.println("\n\n########----- P R O F I L E   P A G E-----########");
            System.out.println("\nUsername  : " +sessionCustomer.getUserName());
            System.out.println("Full Name : " +sessionCustomer.getFirstName()+ " " + sessionCustomer.getLastName());
            System.out.println("Email     : "+sessionCustomer.getEmail());
            System.out.println("Password  : "+sessionCustomer.getPassword());
            System.out.println("Address   : "+sessionCustomer.getAddress());


            System.out.println("\n1.Change Username");
            System.out.println("2.Change Email");
            System.out.println("3.Change Password");
            System.out.println("4.Change Payment Password");
            System.out.println("5.Update Address");
            System.out.println("6.Delete Account");
            System.out.println("7.Return to Home Page");

            int userChoice = 0;         // Get the choice

            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 7) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 / 6 or 7 only.");
                        validInput = false;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

            } while (!validInput);


            Customer customer = sessionCustomer;
            switch (userChoice) {
                case 1:
                        System.out.print("Your new username : ");
                        String username = input.next();
                        customer.setUserName(username);
                        customerDAO.updateCustomer(customer);
                        break;
                case 2:
                        System.out.print("Your new Email : ");
                        String email = input.next();
                        customer.setEmail(email);
                        customerDAO.updateCustomer(customer);
                        break;
                case 3:
                        System.out.print("Your new Password : ");
                        String password = input.next();
                        customer.setPassword(password);
                        customerDAO.updateCustomer(customer);
                        break;
                case 4:
                    System.out.print("Your new Payment Password : ");
                    String paymentPassword = input.next();
                    customer.setPaymentPassword(paymentPassword);
                    customerDAO.updateCustomer(customer);
                    break;

                case 5:
                        input.nextLine();
                        System.out.print("Your new Address : ");
                        String address = input.nextLine();
                        customer.setAddress(address);
                        customerDAO.updateCustomer(customer);
                        break;
                case 6:
                        System.out.println("Are you sure to delete the account?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");

                        do {
                            try {
                                System.out.print("\nYour option : ");
                                deleteConfirmation = input.nextInt();
                                validInput = true;

                                if (deleteConfirmation < 1 || deleteConfirmation > 2) {
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

                        if (deleteConfirmation == 1) {
                            customerDAO.deleteCustomer(sessionCustomer);
                            System.out.println("It's sad to see you go !");
                        } else {
                            System.out.println("You have chose to not delete your account !");
                        }
                         break;

                default: redirectToTopFlag = false;
                break;


            }

        }while(redirectToTopFlag);

        if ( deleteConfirmation ==1)
        {
            mainMenuPage();
        }
        else{

            System.out.println("\n\nYou will be redirected to Home Page");
            promptEnterKey();
        }

    }



    public static void exitSystem( ) {
        System.out.println("\n\nThe system will now end");
        System.exit(0);

        // Shut down system
    }








    public static void sellerDashboardPage() {


        boolean returnToDashboard = true;

        do {
            System.out.println("\n########----- D A S H B O A R D   P A G E-----########");
            System.out.println("1. Manage Orders");
            System.out.println("2. Manage Products");
            System.out.println("3. Manage Feedbacks");
            System.out.println("4. Manage Payment");
            System.out.println("5. Manage Profile");
            System.out.println("6. Manage Notification");
            System.out.println("7. Log Out");

            int userChoice = 0;
            boolean validInput;
            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 7) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 / 6 or 7 only.");
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
                    manageOrdersPage();
                    break;
                case 2:
                    manageProductPage();
                    break;
                case 3:
                    manageFeedbackPage();
                    break;
                case 4:
                    managePaymentPage();
                    break;
                case 5:
                    manageSellerProfilePage();
                    break;
                case 6:
                    manageSellerNotificationPage();
                    break;
                case 7:
                    returnToDashboard = false;
                    break;
            }


        } while (returnToDashboard);

        System.out.println("You will be now logged out ....");
        logOutPage('s');

    }


    public static void manageProductPage() {

        boolean returnToManageProductPage = true;

        do {

            System.out.println("\n########----- MANAGE PRODUCT PAGE-----########");

            System.out.println("1.View list of products \n2.Add product  \n3.Update product  \n4.Delete product  \n5.Search a product \n6.Return to Dashboard");

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
                    ArrayList<Product> listOfProductOfThisSeller = productDAO.getListOfProductsOfThisSeller(sessionSeller.getSellerID());

                    // View list of products and stock counts
                    System.out.println("Product ID     Name           Category       Price          Stock          Sales");
                    for (Product product : listOfProductOfThisSeller) {
                        System.out.printf("%s%18s%18s%13s%14s%14s\n",
                                product.getProductID(),
                                product.getProductName(),
                                product.getProductCategory(),
                                product.getProductPrice(),
                                product.getProductStockCount(),
                                product.getProductSalesCount());

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

        } while (returnToManageProductPage);


    }

    public static void addProductPage() {


        // Get the name, using nextLine to allow to have space between name of product
        System.out.print("Enter the name of product : ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Enter the category of product : ");
        String category = input.nextLine();

        System.out.print("Enter the description of product : ");
        String description = input.nextLine();

        System.out.print("Enter the price of product : RM ");
        double price = input.nextDouble();

        System.out.print("Enter the stock of product : ");
        int stock = input.nextInt();

        //Get productDOA in seller class, write a method to return object of ProductDOA
        productDAO.addProduct(new Product(sessionSeller.getSellerID(), 0, name, description, category, price, stock, 0));

    }

    public static void updateProductPage() {

        char contUpdateConfirmation = 'N';
        do {
            System.out.print("Enter the Product ID to update : ");
            int productID = input.nextInt();

            Product product = productDAO.getProduct(productID);

            if (product != null) {

                System.out.println("1. Update Name\n2. Update Description \n3. Update Category\n4. Update Stock\n5. Update Price\n6. Return");
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

                input.nextLine();
                switch (userChoice) {

                    case 1:
                        System.out.print("New Product Name : ");
                        String productName = input.nextLine();
                        product.setProductName(productName);
                        productDAO.updateProduct(product);
                        break;
                    case 2:
                        System.out.print("New Product Description : ");
                        String productDescription = input.nextLine();
                        product.setProductDescription(productDescription);
                        productDAO.updateProduct(product);
                        break;
                    case 3:
                        System.out.print("New Product Description : ");
                        String productCategory = input.nextLine();
                        product.setProductCategory(productCategory);
                        productDAO.updateProduct(product);
                        break;
                    case 4:
                        System.out.print("New Product Stock Count : ");
                        int productStockCount = input.nextInt();
                        product.setProductStockCount(productStockCount);
                        productDAO.updateProduct(product);
                        break;
                    case 5:
                        System.out.print("New Product Price : RM ");
                        double productPrice = input.nextDouble();
                        product.setProductPrice(productPrice);
                        productDAO.updateProduct(product);
                        break;

                }

            } else {
                System.out.print("Uh oh , product is not found please enter correct product ID");
                System.out.print("Do you still want to update ? Press 'Y' for YES  and Press 'N' for NO");
                contUpdateConfirmation = input.next().charAt(0);
            }

        } while (contUpdateConfirmation == 'Y');


    }

    public static void deleteProductPage() {
        System.out.print("Enter the Product ID to delete :");
        int productID = input.nextInt();

        Product product = productDAO.getProduct(productID);
        char contUpdateConfirmation = 'N';

        do {
            if (product != null) {
                productDAO.deleteProduct(product);
                System.out.println("Successfully deleted product");

            } else {
                System.out.print("Uh oh , product is not found please enter correct product ID");
                System.out.print("Do you still want to delete ? Press 'Y' for YES  and Press 'N' for NO");
                contUpdateConfirmation = input.next().charAt(0);
            }

        } while (contUpdateConfirmation == 'Y');

    }

    public static void searchAndDisplayProductPage() {
        System.out.print("Enter the Product ID to search : ");
        int productID = input.nextInt();

        Product product = productDAO.getProduct(productID);
        char contUpdateConfirmation = 'N';

        do {
            if (product != null) {
                System.out.println(
                        "Product Name : " + product.getProductName() +
                                "Product Category :  " + product.getProductCategory() +
                                "Product Price : RM " + product.getProductPrice() +
                                "Stock Available : " + product.getProductStockCount() +
                                "Sold Quantity : " + product.getProductSalesCount() +
                                "Product Rating : " + feedbackDAO.getAverageRatingOfThisProduct(productID) +
                                "Product Description : " + product.getProductDescription()
                );


                System.out.println("Product Reviews : ");
                ArrayList<Feedback> searchedProductFeedback = feedbackDAO.getListOfFeedbackOfThisProduct(productID);
                if (searchedProductFeedback != null) {

                    for (Feedback feedback : searchedProductFeedback) {
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println(
                                "User " + customerDAO.getCustomerUsername(feedback.getFeedbackCustomerID()) + ": \n" +
                                        feedback.getFeedbackReview() +
                                        "Comment By You : \n" + feedback.getFeedbackCommentBySeller()
                        );
                        System.out.println("------------------------------------------------------------------------------------");

                    }
                }else{
                    System.out.println("No Reviews yet :(");

                }
            } else {
                System.out.print("Uh oh , product is not found please enter correct product ID");
                System.out.print("Do you still want to search ? Press 'Y' for YES  and Press 'N' for NO");
                contUpdateConfirmation = input.next().charAt(0);
            }

        } while (contUpdateConfirmation == 'Y');
    }








    public static void manageOrdersPage() {


        System.out.println("########----- MANAGE ORDERS PAGE-----########");

        System.out.println("No      Order ID    Order Date      Product Name       Order Status       Customer Name");

        //First list all the orders that matches the seller
        ArrayList<Orders> listOfOrders = ordersDAO.getListOfOrdersOfSeller(sessionSeller.getSellerID());
        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println((i + 1) + "      " +
                    listOfOrders.get(i).getOrderID() + "      " +
                    listOfOrders.get(i).getOrderDate() + "      " +
                    productDAO.getProduct(listOfOrders.get(i).getOrderProductID()).getProductName() + "      " +
                    listOfOrders.get(i).getOrderStatus() + "      " +
                    customerDAO.getCustomerFullName(listOfOrders.get(i).getOrderCustomerID()));
        }

        System.out.println("\n1.View details of an Order");
        System.out.println("2.Return to home page");
        int userChoice = 0;         // Get the choice


        boolean validInput;
        do {
            try {
                System.out.print("\nYour option : ");
                userChoice = input.nextInt();
                validInput = true;

                if (userChoice < 1 || userChoice > 2) {
                    System.out.print("Oops wrong value, please enter either 1 or 2 only.");
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

            System.out.print("Enter the Order ID to view the details : ");
            int orderID = input.nextInt();

            System.out.println("\n-----DETAILS OF ORDER -----");

            //If we want to view more details
            Orders order = ordersDAO.getOrders(orderID);

            System.out.println(
                    "Order ID     : " + order.getOrderID() + "\n" +
                            "Order Date   : " + order.getOrderDate() + "\n" +
                            "Order Status : " + order.getOrderStatus() + "\n" +
                            "Product Name : " + productDAO.getProduct(order.getOrderProductID()).getProductName() + "\n" +
                            "Product Price    : " + productDAO.getProduct(order.getOrderProductID()).getProductPrice() + "\n" +
                            "Quantity Ordered : " + order.getOrderQuantity()+ "\n" +
                            "Customer Name : "+customerDAO.getCustomerFullName(order.getOrderCustomerID())+ "\n" +
                            "Customer Address : "+customerDAO.getCustomerAddress(order.getOrderCustomerID()));


            if (Objects.equals(order.getOrderStatus(), "Unprocessed")) {

                System.out.print("\nWould you like to update the order ? Y = Yes or N = No : ");
                char orderReceivedConfirmation = input.next().charAt(0);
                input.nextLine();

                if (orderReceivedConfirmation == 'Y') {
                    System.out.print("Enter the Tracking ID : ");
                    order.setOrderTrackingID(input.nextLine());
                    order.setOrderStatus("Processing / Shipping");
                    ordersDAO.updateOrders(order);
                    System.out.print("Updated Order Successfully ! ");

                }

            }
            else{
                System.out.println("Tracking ID     : " + order.getOrderTrackingID());
            }
        }
        System.out.println("\nYou will be redirected to Home Page");
        promptEnterKey();

    }

    public static void manageFeedbackPage() {

        System.out.println("\n\n########----- MANAGE FEEDBACK PAGE-----########");

        ArrayList<Feedback> feedbackOfThisSeller = feedbackDAO.getListOfFeedbackOfThisSeller(sessionSeller.getSellerID());

        if( feedbackOfThisSeller!= null){
            System.out.println("\nFeedback ID    Product ID       Product Name       Given Review       Given Rating   Customer Username  Comment By You");

            for (int i = 0; i < feedbackOfThisSeller.size(); i++) {

                System.out.println(
                        feedbackOfThisSeller.get(i).getFeedbackID() + "              " +
                        feedbackOfThisSeller.get(i).getFeedbackProductID() + "                " +
                        productDAO.getProduct(feedbackOfThisSeller.get(i).getFeedbackProductID()).getProductName() + "     " +
                        feedbackOfThisSeller.get(i).getFeedbackReview() + " " +
                        feedbackOfThisSeller.get(i).getFeedbackRating() + " " +
                        customerDAO.getCustomerUsername(feedbackOfThisSeller.get(i).getFeedbackCustomerID()) + " " +
                        feedbackOfThisSeller.get(i).getFeedbackCommentBySeller()
                );
            }

            //Ask if seller would like to comment for any feedback
            System.out.println("\n\nWould you like to comment for any feedback ?\n1. To comment\n2. To Return");
            int userChoice = 99;
            boolean validInput;

            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 2) {
                        System.out.print("Oops wrong value, please enter either 1 or 2 only.");
                        validInput = false;
                        input.nextLine();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

            } while (!validInput);


            if (userChoice == 1) {// IF user chose to comment , ask for Feedback ID
                System.out.print("\nPlease enter Feedback ID that you want to comment : ");
                int feedbackID = input.nextInt();
                input.nextLine();

                System.out.println("Please enter your comment below : ");
                String comment = input.nextLine();

                Feedback feedbackToUpdate = feedbackDAO.getFeedback(feedbackID);
                feedbackToUpdate.setFeedbackCommentBySeller(comment);
                feedbackDAO.updateFeedback(feedbackToUpdate);

                System.out.println("Successfully updated the feedback with your comment ");

            }
        }else{
            System.out.println("\nYay , there's no feedback to comment");

        }

        System.out.println("\nYou will be redirected to Home Page");
        promptEnterKey();

    }

    public static void managePaymentPage() {

        System.out.println("\n\n########----- MANAGE PAYMENT PAGE-----########");
        System.out.println("Total Profit : RM " + sessionSeller.getSellerProfit() + "\n");
        System.out.println("No      Transaction ID        Amount       Date & Time");

        ArrayList<Transaction> listOfTransaction = sessionSeller.getSellerTransactions();

        if (listOfTransaction!= null){
            for (int i = 0; i < listOfTransaction.size(); i++) {

                System.out.println((i + 1) + "       " +
                        "TR"+listOfTransaction.get(i).getTransactionID() + "                   " +
                        "RM "+listOfTransaction.get(i).getTransactionAmount() + "      " +
                        listOfTransaction.get(i).getTransactionDateTime()
                );


            }

        }else{
            System.out.println("\nNo transactions yet !");
        }


        System.out.println("\n\nYou will be now redirected to Dashboard Page");
        promptEnterKey();


    }

    public static void manageSellerProfilePage() {

        boolean validInput;
        boolean redirectToTopFlag = true;

        do {
            System.out.println("\n\n########----- MANAGE PROFILE PAGE-----########");
            System.out.println("1.Change Username");
            System.out.println("2.Change Name");
            System.out.println("3.Change Email");
            System.out.println("4.Change Password");
            System.out.println("5.Update Address");
            System.out.println("6.Change Phone Number");
            System.out.println("7.Change Bank Account");
            System.out.println("8.Return to Home Page");
            int userChoice = 0;         // Get the choice


            do {
                try {
                    System.out.print("\nYour option : ");
                    userChoice = input.nextInt();
                    validInput = true;

                    if (userChoice < 1 || userChoice > 8) {
                        System.out.print("Oops wrong value, please enter either 1 / 2 / 3 / 4 / 5 / 6 / 7 or 8 only.");
                        validInput = false;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("You have entered an invalid format of input");
                    validInput = false;
                    input.nextLine();
                }

            } while (!validInput);


            switch (userChoice) {
                case 1:
                    System.out.print("Your new username : ");
                    String username = input.next();
                    sessionSeller.setUserName(username);
                    break;
                case 2:
                    System.out.print("Your new First Name  : ");
                    String firstName = input.next();
                    sessionSeller.setFirstName(firstName);

                    System.out.print("Your new Last Name  : ");
                    String lastName = input.next();
                    sessionSeller.setLastName(lastName);
                    break;
                case 3:
                    System.out.print("Your new Email : ");
                    String email = input.next();
                    sessionSeller.setEmail(email);
                    break;
                case 4:
                    System.out.print("Your new Password : ");
                    String password = input.next();
                    sessionSeller.setPassword(password);
                    break;
                case 5:
                    System.out.print("Your new Address : ");
                    String address = input.nextLine();
                    sessionSeller.setSellerAddress(address);
                    break;
                case 6:
                    System.out.print("Your new Phone Number : ");
                    String phoneNum = input.nextLine();
                    sessionSeller.setSellerPhoneNumber(phoneNum);
                    break;
                case 7:
                    System.out.print("Your new Bank Account : ");
                    String bankAccount = input.nextLine();
                    sessionSeller.setSellerBankAccount(bankAccount);
                    break;
                case 8: redirectToTopFlag= false;
                break;
            }

            if( userChoice!=8){
                sellerDAO.updateSeller(sessionSeller);
            }


        }while(redirectToTopFlag);

        System.out.println("\n\nYou will be now redirected to Dashboard Page");
        promptEnterKey();


    }

    public static void manageSellerNotificationPage() {


        System.out.println("########----- MANAGE NOTIFICATION PAGE-----########");

        ArrayList<Notification> listOfNotificationOfSeller = notificationDAO.getListOfNotificationOfSeller(sessionSeller.getSellerID());

        if (listOfNotificationOfSeller != null) {

            for (int i = 0; i < listOfNotificationOfSeller.size(); i++) {
                System.out.println(i + 1 + ".   " + "New Order( Order ID : " + listOfNotificationOfSeller.get(i).getNotificationOrderId() + ") arrived for " + productDAO.getProduct(listOfNotificationOfSeller.get(i).getNotificationProductID()).getProductName() + " from " + customerDAO.getCustomerFullName(listOfNotificationOfSeller.get(i).getNotificationCustomerID()));
                notificationDAO.deleteNotification(listOfNotificationOfSeller.get(i).getNotificationID());
            }
        } else {
            System.out.println("\nYay there's no notification to display !");

        }

        System.out.println("\n\nYou will be now redirected to to Dashboard Page");
        promptEnterKey();
    }


    public static void main(String[] args) {

        mainMenuPage();


    }
}

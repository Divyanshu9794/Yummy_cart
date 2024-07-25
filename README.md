# Yummy Cart

Yummy Cart is an Android food ordering application designed to provide a seamless experience for users to search for restaurants and book their favorite food based on their location. The app includes separate interfaces for users and admins (restaurant owners), ensuring a personalized and efficient experience for both parties.

## Features

### User Features

- **User Authentication**: Secure login through email, Facebook ID, or Google ID.
- **Location Selection**: Users can select their location to get tailored restaurant recommendations.
- **Restaurant Search**: Locate restaurants based on the user's selected location.
- **Food Booking**: Browse restaurant menus, add food items to the cart (with a maximum of 10 items), and place orders.
- **Order Confirmation**: Users receive a confirmation fragment upon placing an order.
- **Profile Management**: Users can update their name, mobile number, and contact details.
- **Cash on Delivery**: Currently, only the Cash on Delivery payment option is available.

### Admin Features

- **Food Management**: Restaurant owners can add food names and details, including ingredients used.
- **Menu Display**: Users can see detailed information about food items, including ingredients.

## Getting Started

### Prerequisites

- Android Studio installed on your computer.
- An Android device or emulator running Android 5.0 (Lollipop) or higher.
- An active internet connection.

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/Yummy_cart.git
    cd Yummy_cart
    ```
2. Open the project in Android Studio:
    - Navigate to `File > Open...` and select the `Yummy_cart` project directory.
3. Sync the project with Gradle files:
    - Click "Sync Project with Gradle Files" in the toolbar.
4. Build and run the project:
    - Select your device or emulator and click "Run".

### Configuration

- Ensure the following permissions are in `AndroidManifest.xml`:
    ```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    ```
- Configure API keys and endpoints in the appropriate configuration files.

## Usage

### For Users

1. **Login**: Start the app and log in with your email, Facebook ID, or Google ID.
2. **Select Location**: Choose your location to find nearby restaurants.
3. **Home Page**: After logging in and selecting a location, you will be redirected to the home page.
4. **Search Restaurants**: Use the search feature to find restaurants by location.
5. **Browse Menu**: View detailed information about food items, including ingredients.
6. **Add to Cart**: Add food items to your cart, with a maximum of 10 items.
7. **Place Order**: Proceed with booking and place your order.
8. **Order Confirmation**: Receive a confirmation fragment after placing an order.
9. **Profile Management**: Update your name, mobile number, and contact details.

### For Admins (Restaurant Owners)

1. **Login**: Access the admin interface with your credentials.
2. **Add Food Items**: Add new food items to the menu, including detailed information and ingredients.
3. **Manage Menu**: Update or remove food items as needed.

## Detailed User Guide

### User Authentication

- **Login Screen**: The login screen allows users to log in with their email, Facebook ID, or Google ID. This ensures a secure and personalized experience.

### Location Selection

- **Location Screen**: After logging in, users are prompted to select their location. This helps tailor the restaurant recommendations to their specific area.

### Home Page

- **Home Screen**: The home screen displays a list of nearby restaurants based on the user's selected location. It also features search and filter options.

### Restaurant Search

- **Search Feature**: Users can search for restaurants by name or cuisine. The search results are filtered based on the user's selected location.

### Food Booking

- **Menu Screen**: Once a restaurant is selected, users can browse the menu and view detailed information about each food item, including ingredients.
- **Add to Cart**: Users can add food items to their cart. Each item can be added up to a maximum of 10 counts.
- **Cart Screen**: The cart screen shows all the items added by the user. Users can modify the quantity or remove items if needed.
- **Place Order**: Users can proceed to place their order from the cart screen. Currently, only the Cash on Delivery option is available.
- **Order Confirmation**: After placing an order, users receive a confirmation fragment that summarizes their order details.

### Profile Management

- **Profile Screen**: Users can update their name, mobile number, and contact details from the profile screen. This ensures their information is always up to date.

## Detailed Admin Guide

### Admin Login

- **Admin Login Screen**: Restaurant owners can log in to the admin interface with their credentials.

### Food Management

- **Add Food Items**: Admins can add new food items to the menu. Each item includes detailed information such as name, description, price, and ingredients.
- **Update/Remove Food Items**: Admins can update or remove existing food items as needed. This ensures the menu is always current and accurate.

### Menu Display

- **Detailed Food Information**: Users can view detailed information about each food item, including the ingredients used. This helps users make informed choices based on their dietary preferences and restrictions.

Yummy Cart aims to enhance your food ordering experience with its user-friendly interface and efficient functionalities. Enjoy easy access to a wide range of restaurants and cuisines right at your fingertips.

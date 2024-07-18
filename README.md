# Yummy Cart

Yummy Cart is an Android food ordering application designed to provide a seamless experience for users to search for restaurants and book their favorite food based on their location. The app requires users to log in using their email or Facebook ID, ensuring a personalized and secure experience.

## Features

- **User Authentication**: Secure login through email or Facebook ID.
- **Restaurant Search**: Locate restaurants based on the user's current location.
- **Food Booking**: Browse restaurant menus and book food items.
- **User-Friendly Interface**: Intuitive design for easy navigation.

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

1. **Login**: Start the app and log in with your email or Facebook ID.
2. **Home Page**: After logging in, you will be redirected to the home page.
3. **Search Restaurants**: Use the search feature to find restaurants by location.
4. **Book Food**: Select items from the menu and proceed with booking.

Yummy Cart aims to enhance your food ordering experience with its user-friendly interface and efficient functionalities. Enjoy easy access to a wide range of restaurants and cuisines right at your fingertips.

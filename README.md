# Shopping Book 🛒🛍️

Shopping Book is a modern, visually-driven Android application designed to help users manage their shopping lists effectively. Developed entirely with Kotlin and Jetpack Compose, it provides a seamless and intuitive user experience for adding, viewing, and deleting shopping items, complete with photographic references.

## ✨ Features

-   **Intuitive Item Listing:** A clean and scrollable list displays all saved shopping items, making it easy to quickly browse your inventory.
-   **Comprehensive Item Management:**
    -   **Add New Item:** Effortlessly add new shopping entries by providing the item name, the store where it can be found, its price, and a relevant image.
    -   **Detailed View:** Access a dedicated screen to view all information about a selected item, presented in a structured and elegant card layout.
    -   **Delete Item:** Easily remove items from your list via the detail screen when they are no longer needed.
-   **Advanced Image Handling:**
    -   **Flexible Image Source:** Choose to attach an image either by selecting an existing photo from your device's **Gallery** or by capturing a new one directly using the **Camera**.
    -   **Smart Permission Management:** Implements robust runtime permission requests for `CAMERA` and storage access (`READ_MEDIA_IMAGES` for Android 13+ or `READ_EXTERNAL_STORAGE` for older versions), ensuring a smooth user onboarding experience.
    -   **Automatic EXIF Correction:** A crucial feature that reads **EXIF metadata** from newly captured camera photos. This intelligently corrects common orientation issues, guaranteeing that images are always displayed upright regardless of how the photo was taken.
-   **Local Data Persistence:** All shopping items and their associated data are securely stored on the device using a **Room Database**, ensuring data availability even without an internet connection.

## 🚀 Technologies & Architecture

The "Shopping Book" app is built upon a solid foundation of modern Android development tools and best practices.

* **Language:** 100% **Kotlin** – Leveraging its conciseness, safety, and modern features.
* **UI Toolkit:** **Jetpack Compose** – Declarative UI for building beautiful and responsive interfaces.
* **Architecture:** **MVVM (Model-View-ViewModel)** – Provides a clear separation of concerns, enhances testability, and improves maintainability of the codebase.
* **Navigation:** **Jetpack Navigation for Compose** – Manages in-app screen transitions and argument passing within a single-activity setup.
* **Database:** **Room Persistence Library** – An abstraction layer over SQLite, offering robust and efficient local data storage.
* **Asynchronicity:** **Kotlin Coroutines** – Used for managing background operations (e.g., database transactions, image processing) efficiently without blocking the main thread.
* **Image Loading:** **Coil (Image Loading Library for Android)** – A fast and lightweight image loading library specifically designed for Kotlin coroutines and Compose.
* **Image Handling Utilities:**
    * `ActivityResultContracts`: For streamlined handling of activity results, such as picking images or taking photos.
    * `FileProvider`: Securely shares content files between apps.
    * `ExifInterface`: For reading and manipulating EXIF data in JPEG images to correct orientation.

## 📸 Screenshots

| List View | Add Item | Choose Source | Detail View |
| :---: | :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/774457c4-3302-44c1-846b-9170af257362" alt="List View" width="200"> | <img src="https://github.com/user-attachments/assets/1a2e1703-5cfe-4995-8116-5125799ed17b" alt="Add Item" width="200"> | <img src="https://github.com/user-attachments/assets/22eb678a-81ff-4a9d-9f0a-6ea39793bf09" alt="Choose Source" width="200"> | <img src="https://github.com/user-attachments/assets/21bcc593-f243-49e0-a77b-a55ce1b6743d" alt="Detail View" width="200"> |



## ⚙️ Setup and Installation

To get a local copy up and running, follow these simple steps.

1.  **Prerequisites:**
    * Android Studio (Hedgehog | 2023.1.1 or newer recommended)
    * Android SDK (API Level 21+ for deployment)

2.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/your-username/shopping-book.git](https://github.com/your-username/shopping-book.git) # Replace with your repo URL
    cd shopping-book
    ```

3.  **Open in Android Studio:**
    * Launch Android Studio.
    * Select `File > Open...` and navigate to the `shopping-book` directory.
    * Allow Gradle to sync and download all necessary dependencies.

4.  **Build and Run:**
    * Connect an Android device or start an emulator.
    * Click the `Run 'app'` button (green triangle) in Android Studio.

    **Note:** For testing camera functionality, it's highly recommended to use a physical Android device or an emulator with a configured camera.

## 🤝 Contributing

Contributions are welcome! If you have suggestions for improving the "Shopping Book" app, please feel free to:

1.  Fork the repository.
2.  Create your feature branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.


## 📞 Contact

Me - [ali.can.dgru10@gmail.com]

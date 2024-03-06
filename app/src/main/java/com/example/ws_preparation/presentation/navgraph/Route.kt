package com.example.ws_preparation.presentation.navgraph

sealed class Route(
    val route: String
) {

    object OnboardScreen: Route("OnboardScreen")
    object SignUpScreen: Route("SignUpScreen")
    object SignInScreen: Route("SignInScreen")
    object ForgotPasswordScreen: Route("ForgotPasswordScreen")
    object OTPVerificationScreen: Route("OTPVerificationScreen?email={email}")
    object NewPasswordScreen: Route("NewPasswordScreen?email={email}")
    object HomeScreen: Route("Home")
    object WalletScreen: Route("Wallet")
    object TrackScreen: Route("Track")
    object ProfileScreen: Route("Profile")


    object SendAPackageScreen: Route("SendAPackageScreen")
    object AddPaymentMethodScreen: Route("AddPaymentMethodScreen")
    object NotificationScreen: Route("NotificationScreen")
    object MainScreen: Route("MainScreen")
    object SendAPackageReceiptScreen: Route("SendAPackageReceiptScreen?data={data}")
    object TransactionSuccessfulScreen: Route("TransactionSuccessfulScreen?uuid={uuid}")


    object SendAPackage2Screen: Route("SendAPackage2Screen")
    object DeliverySuccessfulScreen: Route("DeliverySuccessfulScreen?order_id={order_id}")



}
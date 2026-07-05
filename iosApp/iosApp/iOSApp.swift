import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        IOSKoinInitializerKt.startKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
package isel.pdm.jokes.daily

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import isel.pdm.jokes.FakeJokesService
import isel.pdm.jokes.about.AboutActivity

const val TAG = "JOKES_TAG"

/**
 * Lecture #5 script
 *
 * Step 1 - Lets briefly review the application's structure
 * Step 2 - Describe the application's UX (navigation)
 * Step 3 - Lets create the About screen, using the same structure as before
 *     Step 3.1 - Create the AboutActivity.
 *     Step 3.2 - Create the AboutScreen. Empty, at first.
 * Step 4 - Add a top bar to both screens.
 *     Step 4.1 - Start by describing the top bar composable and the possible actions.
 *     Step 4.2 - Add the top bar to the Joke Screen with navigation to the About screen.
 *     Step 4.3 - Add the top bar to the About Screen with back navigation.
 * Step 5 - Implement the AboutScreen.
 * Step 6 - Refactor the main screen so that it uses the RefreshFab composable.
 *     Step 5.1 - Describe the RefreshFab composable.
 *     Step 5.2 - Use it on the MainScreen.
 * Step 7 - Add a delay to the joke fetching and observe the consequences of a reconfiguration.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "MainActivity.onCreate: called")
        super.onCreate(savedInstanceState)
        setContent {
            JokeScreen(
                service = FakeJokesService(),
                onInfoRequested = {
                    AboutActivity.navigateTo(origin = this)
                }
            )
        }
    }

    override fun onStart() {
        Log.v(TAG, "MainActivity.onStart: called")
        super.onStart()
    }

    override fun onStop() {
        Log.v(TAG, "MainActivity.onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.v(TAG, "MainActivity.onDestroy: called")
        super.onDestroy()
    }
}

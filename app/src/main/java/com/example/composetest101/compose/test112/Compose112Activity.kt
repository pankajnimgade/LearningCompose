package com.example.composetest101.compose.test112

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.R
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme

/**
 * https://developer.android.com/develop/ui/compose/tutorial
 */
class Compose112Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conversation()
        }
    }

}

@Composable
fun Conversation(
    modifier: Modifier = Modifier, messages: List<Message> = createDummyListOfMessages()
) {
    LazyColumn {
        items(messages) {
            MessageCard(message = it)
        }
    }
}

@Preview
@Composable
fun ShowPreviewOfConversation() {
    Conversation()
}


fun createDummyListOfMessages(): List<Message> {
    return SampleData.conversationSample
}

data class Message(val author: String, val body: String)

@Composable
private fun MessageCard(message: Message = Message("Android", "Jetpack Compose")) {
    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    )
    ComposeTest101Theme {
        Surface {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_picture),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        .padding(8.dp)
                        // Set image size to 40 dp
                        .size(40.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)

                )
                MySpace()
                Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                    Text(
                        text = message.author,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall
                    )
                    MySpace()
                    Surface(
                        color = surfaceColor,
                        shape = MaterialTheme.shapes.medium,
                        shadowElevation = 1.dp,
                        modifier = Modifier
                            .animateContentSize()
                            .padding(1.dp)
                    ) {
                        Text(
                            text = message.body,
                            modifier = Modifier.padding(all = 4.dp),
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 250, heightDp = 150)
@Preview(
    showBackground = true, widthDp = 250, heightDp = 150, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ShowPreviewOfMessageCard() {
    ComposeTest101Theme {
        Surface(color = MaterialTheme.colorScheme.primary) {
            MessageCard(message = Message("Lexy", "Hey, take a look at Jetpack Compose"))
        }
    }
}

@Composable
fun MySpace(modifier: Modifier = Modifier) {
    Spacer(
        modifier = Modifier
            .height(4.dp)
            .width(4.dp)
            .wrapContentHeight()
            .wrapContentWidth()
    )
}

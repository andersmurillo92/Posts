package com.andersmurillo92.posts.views.post.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andersmurillo92.posts.data.model.PostModel

class PostDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val post = intent.getSerializableExtra("post") as PostModel
        setContent {
            PostDetailView(post)
        }
    }
}

@Composable
fun PostDetailView(postModel: PostModel) {

    val spaceKeyline = 16.dp

    Column (Modifier.fillMaxSize().padding(spaceKeyline), Arrangement.Center){
        Text(postModel.title.toString().capitalize(), modifier = Modifier.fillMaxWidth(), fontSize = 24.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.size(spaceKeyline))

        Text(postModel.body.toString().capitalize(), fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}
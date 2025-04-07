package com.andersmurillo92.posts.views.post.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andersmurillo92.posts.R
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
fun Modifier.customBackground(
    radius: Float = 0f,
    color: Color = colorResource(id = R.color.color_primary)
): Modifier {
    return this.background(color = color, shape = RoundedCornerShape(radius.dp))
}

@Composable
fun PostDetailView(postModel: PostModel) {

    val spaceKeyline = 16.dp

    Column (Modifier.fillMaxSize().customBackground(), Arrangement.Center){
        Text(
            postModel.title.toString().capitalize(),
            modifier = Modifier.fillMaxWidth().padding(spaceKeyline),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White)

        Spacer(modifier = Modifier.size(spaceKeyline))

        Text(
            postModel.body.toString().capitalize(),
            modifier = Modifier.fillMaxWidth().padding(spaceKeyline),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.White)
    }
}
package study.rtvx.finalstudyappkypcov

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates
import kotlin.random.Random


private val arrayImg = arrayOf(
    R.drawable.edible1,
    R.drawable.inedible1,
    R.drawable.edible2,
    R.drawable.inedible2,
    R.drawable.edible3,
    R.drawable.inedible3,
    R.drawable.edible4,
    R.drawable.inedible4,
    R.drawable.edible5,
    R.drawable.inedible5,
    R.drawable.edible6,
    R.drawable.inedible6,
    R.drawable.edible7,
    R.drawable.inedible7,
    R.drawable.edible8,
    R.drawable.inedible8,
    R.drawable.edible9,
    R.drawable.inedible9,
    R.drawable.edible10,
    R.drawable.inedible10
)
private val priority = arrayOf(
    1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0
)

private val arrayImgSize = arrayImg.size

private const val SCORE = "Score"
private const val LEFT_IMG = "Left img"
private const val RIGHT_IMG = "Right img"


class Game : AppCompatActivity() {

    private lateinit var scoreTextView: TextView
    private var point: Int = 0
    private var leftRandom by Delegates.notNull<Int>()
    private var rightRandom by Delegates.notNull<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val leftImg: ImageView = findViewById(R.id.left_img)
        val rightImg: ImageView = findViewById(R.id.right_img)
        var leftPriority: Int
        var rightPriority: Int

        if (savedInstanceState != null) {
            point = savedInstanceState.getInt(SCORE)
            leftRandom = savedInstanceState.getInt(LEFT_IMG)
            rightRandom = savedInstanceState.getInt(RIGHT_IMG)

        } else {
            leftRandom = Random.nextInt(arrayImgSize)
            rightRandom = Random.nextInt(arrayImgSize)
        }

        scoreTextView = findViewById(R.id.score_text_view)
        scoreTextView.text = "$point"

        //set left img
        fun setLeftImg(): Int {
            leftPriority = priority[leftRandom]
            leftImg.setImageResource(arrayImg[leftRandom])
            return leftPriority
        }

        //set right img
        fun setRightImg(): Int {
            rightPriority = priority[rightRandom]
            rightImg.setImageResource(arrayImg[rightRandom])
            while (setLeftImg() == rightPriority) {
                rightRandom = Random.nextInt(arrayImgSize)
                rightPriority = priority[rightRandom]
                rightImg.setImageResource(arrayImg[rightRandom])
            }
            return rightPriority
        }

        //count counter
        fun plusScore() {
            point += 1
            scoreTextView.text = "$point"
        }

        fun minusScore() {
            if (point == 0) {
                point = 0
            } else
                point -= 1
            scoreTextView.text = "$point"
        }

        //End of the game
        fun endGame() {
            if (point == 10) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                val text = "Поздравляю! Вы прошли игру!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }

        //Show left and right img
        leftPriority = setLeftImg()
        rightPriority = setRightImg()
        fun newElement(){
            leftRandom = Random.nextInt(arrayImgSize)
            setLeftImg()
            rightRandom = Random.nextInt(arrayImgSize)
            setRightImg()
            endGame()
        }

        //Pressing left img
        leftImg.setOnClickListener {
            if (leftPriority > rightPriority) {
                plusScore()
            } else {
                minusScore()
            }
            newElement()

        }
        // Pressing right img
        rightImg.setOnClickListener {
            if (rightPriority > leftPriority) {
                plusScore()
            } else {
                minusScore()
            }
            newElement()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE, point)
        outState.putInt(LEFT_IMG, leftRandom)
        outState.putInt(RIGHT_IMG, rightRandom)
    }
}


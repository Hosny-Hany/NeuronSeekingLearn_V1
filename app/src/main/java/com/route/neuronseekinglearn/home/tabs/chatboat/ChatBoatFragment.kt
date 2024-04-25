package com.route.neuronseekinglearn.home.tabs.chatboat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.neuronseekinglearn.databinding.FragmentChatBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class ChatBoatFragment : Fragment() {
    private lateinit var viewBinding: FragmentChatBinding
    private lateinit var textInput: EditText
    private lateinit var sendInput: Button
    private lateinit var chatTextView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private val messageList: MutableList<Message> = mutableListOf()
    private val client: OkHttpClient = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentChatBinding.inflate(layoutInflater)
        textInput = viewBinding.contentChat.textInput
        sendInput = viewBinding.contentChat.sendInput
        chatTextView = viewBinding.contentChat.RecyclerView

        chatAdapter = ChatAdapter(messageList)
        chatTextView.adapter = chatAdapter

        sendInput.setOnClickListener {
            val userInput = textInput.text.toString()
            sendMessageToFlask(userInput)
        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.lifecycleOwner = this
    }

    private fun sendMessageToFlask(message: String) {
        // Add user message to the chat interface
        val userMessage = Message(message, true)
        messageList.add(userMessage)
        chatAdapter.notifyItemInserted(messageList.size - 1)
        textInput.text.clear()

        // Create request body
        val requestBody = RequestBody.create(
            "application/json; charset=utf-8".toMediaTypeOrNull(),
            "{\"user_input\": \"$message\"}"
        )

        // Create request
        val request = Request.Builder()
            .url("http://192.168.1.14:5000/api/chat")
            .post(requestBody)
            .build()

        // Send request and handle response
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        requireContext(),
                        "Failed to send message: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.use { responseBody ->
                    if (!response.isSuccessful) {
                        throw IOException("Unexpected code ${response.code}")
                    }

                    try {
                        // Get response body as a string
                        val responseString = response.string()
                        Log.d("Response Body", responseString ?: "")

                        // Parse JSON response
                        val jsonResponse = JSONObject(responseString!!)
                        val botResponse = jsonResponse.getString("response")

                        // Update chat interface with bot's response
                        activity?.runOnUiThread {
                            val botMessage = Message(botResponse, false)
                            messageList.add(botMessage)
                            chatAdapter.notifyItemInserted(messageList.size - 1)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        activity?.runOnUiThread {
                            Toast.makeText(
                                requireContext(),
                                "Error: ${e.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        })
    }

    private fun Response.string(): String? {
        return this.body?.string()
    }
}

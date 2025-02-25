import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            val alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            val mediaPlayer = MediaPlayer.create(context, alarmUri) // ✅ No more ambiguity!
//            val mediaPlayer = MediaPlayer.create(context, R.raw.alarm_sound) // ✅ Correct way for raw sounds

            mediaPlayer?.start()
        }
    }
}

import com.app.asakatsuyaroze.database.AlarmPattern
import java.io.Serializable;

class AlarmPatternSerializable(alarmPatternInput: AlarmPattern) :
    Serializable {
    var alarmPattern:AlarmPattern?  = null



//    @JvmName("getAlarmPattern1")
//    private fun getAlarmPattern(): AlarmPattern? {
//        return alarmPattern
//    }

    init {
        alarmPattern = alarmPatternInput
    }
}
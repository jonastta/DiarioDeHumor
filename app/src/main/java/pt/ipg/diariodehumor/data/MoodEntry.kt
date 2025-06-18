package pt.ipg.diariodehumor.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "mood_entries")
data class MoodEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String, // formato: "2025-06-12"
    val mood: String, // emoji ou descrição ex: "😊"
    val note: String
)

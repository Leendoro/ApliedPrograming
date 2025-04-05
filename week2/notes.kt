// Data class to represent a Note
data class Note(val id: Int, var title: String, var content: String)

// NoteManager class to handle notes
class NoteManager {
    private val notes = mutableListOf<Note>()
    private var nextId = 1

    // Function to add a note
    fun addNote(title: String, content: String) {
        val note = Note(id = nextId++, title = title, content = content)
        notes.add(note)
        println("✅ Note added: ${note.title}")
    }

    // Function to edit a note
    fun editNote(id: Int, newTitle: String, newContent: String) {
        val note = notes.find { it.id == id }
        if (note != null) {
            note.title = newTitle
            note.content = newContent
            println("✏️ Note edited.")
        } else {
            println("⚠️ Note not found.")
        }
    }

    // Function to list all notes
    fun listNotes() {
        if (notes.isEmpty()) {
            println("📭 No notes yet.")
        } else {
            println("📚 All Notes:")
            for (note in notes) {
                println("- [${note.id}] ${note.title}")
            }
        }
    }

    // Function to view a single note
    fun viewNote(id: Int) {
        val note = notes.find { it.id == id }
        if (note != null) {
            println("📝 Note #${note.id}")
            println("Title: ${note.title}")
            println("Content: ${note.content}")
        } else {
            println("⚠️ Note not found.")
        }
    }
}

// Entry point
fun main() {
    val manager = NoteManager()
    var running = true

    println("🗒️ Welcome to Kotlin Note-Taking App!")

    while (running) {
        println(
            """
            |Choose an option:
            |1. Add Note
            |2. Edit Note
            |3. List Notes
            |4. View Note
            |5. Quit
        """.trimMargin()
        )

        val input = readLine()?.toIntOrNull()

        when (input) {
            1 -> {
                print("Enter title: ")
                val title = readLine() ?: ""
                print("Enter content: ")
                val content = readLine() ?: ""
                manager.addNote(title, content)
            }
            2 -> {
                print("Enter note ID to edit: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    print("New title: ")
                    val newTitle = readLine() ?: ""
                    print("New content: ")
                    val newContent = readLine() ?: ""
                    manager.editNote(id, newTitle, newContent)
                } else {
                    println("❌ Invalid ID")
                }
            }
            3 -> manager.listNotes()
            4 -> {
                print("Enter note ID to view: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    manager.viewNote(id)
                } else {
                    println("❌ Invalid ID")
                }
            }
            5 -> {
                running = false
                println("👋 Goodbye!")
            }
            else -> println("❓ Unknown option.")
        }
    }
}

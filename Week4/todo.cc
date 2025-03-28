#include <iostream>
#include <vector>
#include <string>

class Task {
public:
    std::string description;
    bool completed;

    Task(const std::string& desc) : description(desc), completed(false) {}
    void markCompleted() { completed = true; }
    void display() const {
        std::cout << "[" << (completed ? "X" : " ") << "] " << description << std::endl;
    }
};

class ToDoList {
private:
    std::vector<Task*> tasks;
public:
    ~ToDoList() {
        for (Task* task : tasks) {
            delete task;
        }
    }
    void addTask(const std::string& desc) {
        tasks.push_back(new Task(desc));
    }
    void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            delete tasks[index];
            tasks.erase(tasks.begin() + index);
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }
    void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks[index]->markCompleted();
        } else {
            std::cout << "Invalid index!" << std::endl;
        }
    }
    void displayTasks() const {
        if (tasks.empty()) {
            std::cout << "No tasks available." << std::endl;
            return;
        }
        for (size_t i = 0; i < tasks.size(); ++i) {
            std::cout << i + 1 << ". ";
            tasks[i]->display();
        }
    }
};

int main() {
    ToDoList todo;
    int choice;
    std::string desc;
    int index;

    do {
        std::cout << "\nTo-Do List Manager\n";
        std::cout << "1. Add Task\n2. Remove Task\n3. Mark Task Completed\n4. View Tasks\n5. Exit\nChoice: ";
        std::cin >> choice;
        std::cin.ignore(); // Ignore newline

        switch (choice) {
            case 1:
                std::cout << "Enter task description: ";
                std::getline(std::cin, desc);
                todo.addTask(desc);
                break;
            case 2:
                std::cout << "Enter task number to remove: ";
                std::cin >> index;
                todo.removeTask(index - 1);
                break;
            case 3:
                std::cout << "Enter task number to mark completed: ";
                std::cin >> index;
                todo.markTaskCompleted(index - 1);
                break;
            case 4:
                todo.displayTasks();
                break;
            case 5:
                std::cout << "Exiting program." << std::endl;
                break;
            default:
                std::cout << "Invalid choice, try again." << std::endl;
        }
    } while (choice != 5);
    
    return 0;
}

# Jen project template

This is a chatbot to help you manage a task list.

## Features
Note that fields in `UPPER_CASE` are to be supplied by the user.


### Viewing all current tasks: `list`
Lists all current tasks.
Format: `list`

### Adding a Todo task: `todo`
Adds a to-do task to your task list.
Format: `todo DESCRIPTION`

Examples:
- `todo read book`
- `todo watch TV`

### Adding a Deadline task: `deadline`
Adds a deadline task to your task list.
Format: `deadline DESCRIPTION /by YYYY-MM-DD`

Examples:
- `deadline Final Exam /by 2025-04-29`
- `deadline Report Submission /by 2025-03-22`

### Adding an Event task: `event`
Adds an event task to your task list.
Format: `event DESCRIPTION /from TIME /to TIME`

Note:
- TIME is stored as a String, can be a time or date or anything
  
Examples:
- `event Travelling to Japan /from 21 March 2025 /to 28 March 2025`
- `event Meeting with Boss /from 12pm /to 2pm`


### Mark a task as done: `mark`
Marks a task as done so that you can see it as completed when you use the `list` command.
Format: `mark NUMBER`

Note:
- NUMBER must be a numerical value representing the task's number in the list. 
- Task now displays with a `[X]` beside it during a `list` command.
- Will return an error if there is no task with the associated NUMBER.

Examples: 
- `mark 1`
- `mark 2`

### Mark a task as not done: `unmark`
Marks a task as done so that you can see it as completed when you use the `list` command.
Format: `unmark NUMBER`

Note:
- NUMBER must be a numerical value representing the task's number in the list. 
- Task now displays with a `[ ]` beside it during a `list` command.
- Will return an error if there is no task with the associated NUMBER.

Examples: 
- `unmark 1`
- `unmark 2`

### Delete a task: `delete`
Deletes a task from the list.
Format: `delete NUMBER`

Note:
- NUMBER must be a numerical value representing the task's number in the list. 
- Will return an error if there is no task with the associated NUMBER.
- Tasks remaining will bump up in the index. For example, you have tasks with numbers 1, 2 and 3. If task 2 is deleted, task 1 will remain as task 1 and task 3 will be the new task 2.

Examples:
- `delete 1`
- `delete 2`

### Add notes to a task: `note`
Adds notes to a task.
Format: `note NUMBER NOTES`

Note:
- NUMBER must be a numerical value representing the task's number in the list.
- Will return an error if there is no task with the associated NUMBER.

Examples:
- `note 2 My favourite task`
- `note 1 Easy to do`


### Find a task with associated keywords: `find`
Searches the list of tasks for tasks where the keyword appears in the task description.
Format: `find KEYWORD`

Note:
- If there is no matching tasks, will display empty list
- If there are matching tasks their associated numbers will be displayed in the results.
- KEYWORD is CaSe SeNsItIvE

Examples:
- `find book`
- `find meeting with boss`


### Close chatbot: `bye`
Closes chatbot, saves existing list and exits window.
Format: `bye`

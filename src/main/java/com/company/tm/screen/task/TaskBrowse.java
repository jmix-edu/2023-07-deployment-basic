package com.company.tm.screen.task;

import com.company.tm.app.TaskImportService;
import com.company.tm.entity.Task;
import io.jmix.ui.component.Button;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("tm_Task.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
public class TaskBrowse extends StandardLookup<Task> {


    @Autowired
    private TaskImportService taskImportService;

    @Autowired
    private CollectionLoader<Task> tasksDl;

    @Subscribe("importTask")
    public void onImportTaskClick(Button.ClickEvent event) {
        taskImportService.getImportTasks();
        tasksDl.load();
    }


}
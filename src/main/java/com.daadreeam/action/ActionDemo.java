package com.daadreeam.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.ui.Messages;
import com.daadreeam.service.ApplicationService;
import com.daadreeam.service.ProjectService;

public class ActionDemo extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        //获取应用级别service，所有开启的idea应用使用一个单例
        ApplicationService applicationService = ServiceManager.getService(ApplicationService.class);
        String appResult = applicationService.handle();
        System.out.println("appResult = " + appResult);

        //获取工程级别service，每个idea使用各自的单例
        ProjectService projectService = ServiceManager.getService(anActionEvent.getProject(), ProjectService.class);
        String projectResult = projectService.handle();
        System.out.println("projectResult = " + projectResult);

        Messages.showMessageDialog(appResult + "\n" +projectResult, "提示", Messages.getInformationIcon());
    }

}

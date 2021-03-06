package inteldt.aspider.custom.writer;

import inteldt.aspider.custom.framework.CrawlerTask;
import inteldt.aspider.custom.framework.Processor;
import inteldt.aspider.custom.manager.TaskManager;

public class FileWriter extends Processor{

	@Override
	protected boolean accept(CrawlerTask task) {
		if(task.isFinished() == false){
			return true;
		}
		return false;
	}

	@Override
	protected void acceptProcess(CrawlerTask task) {
//		FileUtils.writeStringToFile("", task., true);
		TaskManager.deleteActiveUrl(task.getUrl());// 任务完成，从活动队列中删除
	}

	@Override
	protected void rejectProcess(CrawlerTask task) {
		TaskManager.deleteActiveUrl(task.getUrl());
	}

}

package inteldt.aspider.custom.framework;

import inteldt.aspider.custom.extractor.Extractor;
import inteldt.aspider.custom.fetcher.FetchHTTP;
import inteldt.aspider.custom.writer.DBWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器链
 * 
 * @author pei
 *
 */
public class ProcessorChain extends Processor{
	
	private static List<Processor> processrChain = new ArrayList<Processor>();
	
	static{
		processrChain.add(new FetchHTTP());
		processrChain.add(new Extractor());
		processrChain.add(new DBWriter());
	}

	@Override
	protected boolean accept(CrawlerTask task) {
		return true;
	}

	@Override
	protected void acceptProcess(CrawlerTask task) {
		for(Processor processor : processrChain){
			processor.process(task);
		}
	}

	@Override
	protected void rejectProcess(CrawlerTask task) {//TODO 
//		do nothing
	}

	
}
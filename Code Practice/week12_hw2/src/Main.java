import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		String InputFileName = args[0];
		
		ArrayList<String> input = new ArrayList<String>();
		input = InputProcess.getInput(InputFileName);
		
		String Widget_name = "";
		GuiApp myGuiApp = new GuiApp();
		PmWidgetFactory pm_factory = new PmWidgetFactory();
		MotifWidgetFactory motif_factory = new MotifWidgetFactory();
		
		for(int i=0;i<input.size();i++) {
			String tmp[] = input.get(i).split(" ");
			if(tmp[0].contentEquals("Window")) {
				Widget_name = tmp[1];
				
				Widget w = motif_factory.createWindow(Widget_name);
				myGuiApp.wigdetlist.add(w);
			}
			if(tmp[0].contentEquals("ScrollBar")) {
				Widget_name = tmp[1];
				
				Widget w = motif_factory.createScrollBar(Widget_name);
				myGuiApp.wigdetlist.add(w);
			}
			if(tmp[0].contentEquals("Button")) {
				Widget_name = tmp[1];
				
				Widget w = motif_factory.createButton(Widget_name);
				myGuiApp.wigdetlist.add(w);
				
			}
			if(tmp[0].contentEquals("Motif")) {
				for(int j=0;j<myGuiApp.wigdetlist.size();j++) {
					if(myGuiApp.wigdetlist.get(j).type.equals("Window")) {
						myGuiApp.wigdetlist.set(j,motif_factory.createWindow(myGuiApp.wigdetlist.get(j).name));
					}
					if(myGuiApp.wigdetlist.get(j).type.equals("ScrollBar")) {
						myGuiApp.wigdetlist.set(j,motif_factory.createScrollBar(myGuiApp.wigdetlist.get(j).name));
					}
					if(myGuiApp.wigdetlist.get(j).type.equals("Button")) {
						myGuiApp.wigdetlist.set(j,motif_factory.createButton(myGuiApp.wigdetlist.get(j).name));
					}
				}
				/*
				for(Widget w : myGuiApp.wigdetlist) {
					if(w.type=="Window") {
						w = motif_factory.createWindow(Widget_name);
					}
					if(w.type=="ScrollBar") {
						w = motif_factory.createScrollBar(Widget_name);
					}
					if(w.type=="Button") {
						w = motif_factory.createButton(Widget_name);
					}
				}
				*/
			}	
			if(tmp[0].contentEquals("PM")) {
				//System.out.println("mumi");
				for(int j=0;j<myGuiApp.wigdetlist.size();j++) {
					
					//System.out.println("***"+myGuiApp.wigdetlist.get(j).type);
					
					if(myGuiApp.wigdetlist.get(j).type.equals("Window")) {
						//System.out.println("mumi");
						myGuiApp.wigdetlist.set(j,pm_factory.createWindow(myGuiApp.wigdetlist.get(j).name));
					}
					if(myGuiApp.wigdetlist.get(j).type.equals("ScrollBar")) {
						//System.out.println("mumi");
						myGuiApp.wigdetlist.set(j,pm_factory.createScrollBar(myGuiApp.wigdetlist.get(j).name));
					}
					if(myGuiApp.wigdetlist.get(j).type.equals("Button")) {
						//System.out.println("mumi");
						myGuiApp.wigdetlist.set(j,pm_factory.createButton(myGuiApp.wigdetlist.get(j).name));
					}
				}
				/*
				for(Widget w : myGuiApp.wigdetlist) {
					if(w.type.contentEquals("Window")) {
						w = pm_factory.createWindow(Widget_name);
					}
					if(w.type.contentEquals("ScrollBar")) {
						w = pm_factory.createScrollBar(Widget_name);
					}
					if(w.type.contentEquals("Button")) {
						w = pm_factory.createButton(Widget_name);
					}
				}
				*/
			}
			if(tmp[0].contentEquals("Present")) {
				for(Widget w : myGuiApp.wigdetlist) {
					w.draw();
				}
			}
		}
	}

}

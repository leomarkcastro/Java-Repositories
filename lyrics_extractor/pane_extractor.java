package lyrics_extractor;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class pane_extractor extends JPanel{

	int WIDTH;
	int HEIGHT;
	
	JTextArea ta;
	
	pane_extractor(int width, int height){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.setBounds(0,0,width, height);
		this.setLayout(null);
		
		ta = new JTextArea("", 5, 50);
		ta.setLineWrap(true);
		ta.setOpaque(false);
		JScrollPane scrollable = new JScrollPane(ta);
		//scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollable.setBounds(12,13,388,527);
		scrollable.setOpaque(false);
		scrollable.setBorder(BorderFactory.createEmptyBorder());
		
		this.add(scrollable);

	}
	
	void update_text() {
		
		ta.setText("aaaaaaaaaaaaaa");
		
	}
}

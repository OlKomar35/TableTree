import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import org.painlessgridbag.PainlessGridBag;

public class TableTree extends JDialog {
  private final JXTable jxTableProfile;
  private final JXTable jxTableTaske;

  public TableTree() {
   this.jxTableProfile= getJXTable(5);
   this.jxTableTaske= getJXTable(5);
    PainlessGridBag gbl= new PainlessGridBag(this,false);
    gbl.row()
            .cell(getScrollPane(jxTableProfile)).fillXY()
            .cell(getScrollPane(jxTableTaske)).fillXY();
    gbl.doneAndPushEverythingToTop();
   this.setSize(300,500);
   this.setVisible(true);
  }

  private JScrollPane getScrollPane(JXTable jxTableProfile) {
    JScrollPane jScrollPane= new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jScrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
    jScrollPane.setViewportView(jxTableProfile);
    jScrollPane.setVerticalScrollBar(jScrollPane.getVerticalScrollBar());
    return jScrollPane;
  }

  private JXTable getJXTable(int rowCount) {
    JXTable jxTable=new JXTable();
    jxTable. setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    jxTable.setColumnControlVisible(true);
    jxTable.setHorizontalScrollEnabled(true);
    jxTable.setEditable(false);
    jxTable.setVisibleRowCount(rowCount);
    jxTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jxTable.setModel(new DefaultTableModel(new String[]{"ID", "Name"},0));
    jxTable.getColumnExt(0).setVisible(false);
    jxTable.getColumnModel().getColumn(0).setCellRenderer(new ActiveColumnCellRenderer());


    System.out.println(5);

    System.out.println(125);
    System.out.println(255);

    return jxTable;



  }
}

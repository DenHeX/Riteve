package Views;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public interface Table {
    public static void filter(JTable tbl,String text) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbl.getModel());
        tbl.setRowSorter(sorter);
        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
}

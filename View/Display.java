package View;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Item;

public interface Display
{

    public void onSubmit(ItemPanel item, JButton But);
    public void onItemLink(ItemPanel item, JButton but);
}

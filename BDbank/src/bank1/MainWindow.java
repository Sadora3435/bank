package bank1;
import javax.swing.*; 
import javax.swing.table.DefaultTableModel; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.List; 

public class MainWindow extends JFrame{  	
    private JTabbedPane tabbedPane; 
    private JTable tableClients, tableAccounts, tableOperations; 
     
    public MainWindow() { 
        setTitle("Банковская система");
        setSize(900, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);        
        Database.testConnection();          
       
        tabbedPane = new JTabbedPane();
        tableClients = new JTable();      
        tableAccounts = new JTable();  
        tableOperations = new JTable(); 
          
        tabbedPane.addTab("Клиенты", createTablePanel(tableClients, "Клиенты"));       
        tabbedPane.addTab("Счета", createTablePanel(tableAccounts, "Счета"));
        tabbedPane.addTab("Операции", createTablePanel(tableOperations, "Операции"));          

        JPanel buttonPanel = new JPanel(); 
        JButton refreshButton = new JButton("Обновить данные"); 
        JButton exitButton = new JButton("Выход"); 
         
        refreshButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) {                
                loadAllData(); 
            } 
        });          
        exitButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                System.exit(0); 
            } 
        });          
        buttonPanel.add(refreshButton); 
        buttonPanel.add(exitButton); 
 
        JPanel mainPanel = new JPanel(new BorderLayout());     
        mainPanel.add(tabbedPane, BorderLayout.CENTER);     
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); 
         
        add(mainPanel); 
        loadAllData(); 
    }      
    
    private JPanel createTablePanel(JTable table, String title) { 
        JPanel panel = new JPanel(new BorderLayout()); 
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);     
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
         
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);    
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
         
        panel.add(titleLabel, BorderLayout.NORTH); 
        panel.add(new JScrollPane(table), BorderLayout.CENTER); 
         
        return panel; 
    }      
    
    private void loadAllData() {       
        loadClients();         
        loadAccounts();       
        loadOperations(); 
    }      
    
    private void loadClients() { 
        clientDAO clientDAO = new clientDAO(); 
        List<client> clients = clientDAO.getAllclient();          
        DefaultTableModel model = new DefaultTableModel();  
        model.addColumn("КлиентАйди"); 
        model.addColumn("Фамилия");
        model.addColumn("Имя");     
        model.addColumn("Отчество");  
        model.addColumn("ИНН");    
        model.addColumn("Номер паспорта"); 
        model.addColumn("Серия паспорта");
        model.addColumn("Номер телефона");
          
        for (client client : clients) {     
            model.addRow(new Object[]{            
                client.getКлиентАйди(),        
                client.getФамилия(),     
                client.getИмя(),      
                client.getОтчество(),  
                client.getИНН(),      
                client.getНомерПаспорта(),
                client.getСерияПаспорта(),
                client.getНомерТелефона()
            }); 
        }          
        tableClients.setModel(model); 
    }      
    
    private void loadAccounts() { 
        accountDAO accountDAO = new accountDAO(); 
        List<account> accountList = accountDAO.getAllaccount(); 
         
        DefaultTableModel model = new DefaultTableModel();    
        model.addColumn("КлиентАйди");       
        model.addColumn("ДатаОткрытия");  
        model.addColumn("Валюта"); 
        model.addColumn("ТипСчёта");
        model.addColumn("Баланс");
        model.addColumn("СчётАйди");  
        model.addColumn("Статус");
         
        for (account account : accountList) {     
            model.addRow(new Object[]{
                account.getКлиентАйди(),    
                account.getДатаОткрытия(),    
                account.getВалюта(),
                account.getТипСчёта(),
                account.getБаланс(),
                account.getСчётАйди(),  
                account.getСтатус()
            }); 
        } 
        tableAccounts.setModel(model); 
    }      
    
    private void loadOperations() {   
        operationDAO operationDAO = new operationDAO(); 
        List<operation> operations = operationDAO.getAlloperation(); 
         
        DefaultTableModel model = new DefaultTableModel();   
        model.addColumn("ОперацияАйди");     
        model.addColumn("СчётАйди");
        model.addColumn("ТипОперации");     
        model.addColumn("Дата");   
        model.addColumn("Сумма");    
         
        for (operation oper : operations) {  
            model.addRow(new Object[]{  
                oper.getОперацияАйди(),
                oper.getСчётАйди(),
                oper.getТипОперации(), 
                oper.getДата(),
                oper.getСумма()        
            }); 
        }          
        tableOperations.setModel(model); 
    }       
     
    public static void main(String[] args) {   
        SwingUtilities.invokeLater(() -> {      
            MainWindow window = new MainWindow();
            window.setVisible(true); 
        }); 
    } 
}
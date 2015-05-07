import javax.swing.JOptionPane;
class LoanCalculate5
    {  public static void main (String[]args)
         {  final double ERROR_MARGIN= .01, SENTINAL= -99999;
            int i= 0;
            double c, m, y, r;
            
            String inputValue= JOptionPane.showInputDialog (null, "Please enter the cost of loan.Enter -99999 for c to terminate loop: ");
            c= Double.parseDouble(inputValue); 
            
            
            for(;c!=SENTINAL;i++)
                 {  
                    do 
                           if (i!=0 || c<0)  
                              {
                                 String inputValueA= JOptionPane.showInputDialog (null, "Please enter the cost of loan.Enter -99999 for c to terminate loop: ");
                                 c= Double.parseDouble(inputValueA);
                                 i--;
                              }
                    while (c<0 && c!=SENTINAL);
                    
                   
                    if (c!= SENTINAL)
                        {
                           do
                              {     
                                 String inputValue2= JOptionPane.showInputDialog (null, "Please enter the amount of monthly payments: ");
                                 m= Double.parseDouble(inputValue2);
                              }
                           while (m<0 || c==0&&m==0);    
                    
                    
                           do
                              {
                                 String inputValue3= JOptionPane.showInputDialog (null, "Please enter the number of years: ");          
                                 y= Double.parseDouble(inputValue3);
                              }   
                           while (y<0 || c==0&&y==0 || m==0&&y==0);     
                    
                    
                           do
                              {
                                 String inputValue4= JOptionPane.showInputDialog (null, "Please enter the interest rate: ");
                                 r= Double.parseDouble(inputValue4);
                              }
                           while (r<=0 || r>=100);
                           
                           
                           if (m==0)
                              {
                                 m= (r*c)/(1200*(1-(Math.pow((1.0+r/1200.0),(-12.0*y)))));
                                 JOptionPane.showMessageDialog (null, "The value of m is: "+m);
                              }
                           else if (c==0) 
                              { 
                                 c= (1200*m*(1-(Math.pow((1.0+r/1200.0),(-12.0*y)))))/r;
                                 JOptionPane.showMessageDialog (null, "The value of c is: "+c);
                              }
                           else 
                              {
                                 y= (Math.log((1-(r*c)/(1200*m))))/(-12*(Math.log((1+r/1200))));
                                 JOptionPane.showMessageDialog (null, "The value of y is: "+y);
                              }
            
            
                           double interest= 12*m*y-c;
                           JOptionPane.showMessageDialog (null, "The total interest value is: "+interest);
                        
                      
                           if (Math.abs(interest-c)<ERROR_MARGIN)
               
                                 JOptionPane.showMessageDialog (null, "The total interest is equal to the cost of the item");
                  
                           else if (interest<c)

                                 JOptionPane.showMessageDialog (null, "The interest is less than the cost of the item");

                           else

                                 JOptionPane.showMessageDialog (null, "The interest is greater than the cost of the item");
                        }   
                 }
                    System.exit(0);     
         }
    }
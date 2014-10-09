/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

/**
 *
 * @author Alican
 */
public class MybigInteger implements Operations {

    public String rawData;
    public MyLinkedList itsNumber;

    public MybigInteger(String yazi) {
        MyLinkedList liste = new MyLinkedList();

        for (int i = 0; i < yazi.length(); i++) {
            liste.add(Character.getNumericValue(yazi.charAt(i)));
        }
        this.itsNumber = liste;
        this.rawData = yazi;

    }

    public MybigInteger() {

    }

    @Override
    public String toString() {
        Node n = this.itsNumber.first;
        String temp = new String();
        while (n != null) {
            temp += n.value;
            n = n.next;
        }
        return temp;
    }

    @Override
    public MybigInteger add(MybigInteger second) {
        MyLinkedList a = this.itsNumber;
        MyLinkedList b = second.itsNumber;
        MyLinkedList result = new MyLinkedList();
        Node current1 = a.first;
        Node current2 = b.first;

        int temp = 0;
        int sum;

        while (current1 != null || current2 != null) {
            sum = 0;

            if (current1 != null && current2 != null) {
                sum += (current1.value + current2.value);
            } else if (current1 != null) {
                sum += current1.value;
            } else if (current2 != null) {
                sum += current2.value;
            }

            if (temp > 0) {
                sum += temp;
            }

            result.add(sum % 10);
            temp = (int) Math.floor(sum / 10);

            if (current1 != null) {
                current1 = current1.next;

            }

            if (current2 != null) {
                current2 = current2.next;

            }
        }

        if (temp > 0) {
            result.add(temp);
        }
        MybigInteger mb = new MybigInteger();
        Node n = result.first;
        MyLinkedList result2 = new MyLinkedList();
//ters cevirme
        while (n != null) {
            result2.add(n.value);
            result.first = n.next;
            n = result.first;

        }
        mb.itsNumber = result2;

        return mb;

    }

    @Override
    public MybigInteger subtract(MybigInteger second) {
        MyLinkedList a = this.itsNumber;
        MyLinkedList b = second.itsNumber;
        MyLinkedList result = new MyLinkedList();
        Node current1 = a.first;
        Node current2 = b.first;
        boolean temp = false;
        
         int sum;
          while (current1 != null || current2 != null) {
              sum = 0;
              
              if (temp) {
                  sum-=1;
                  if (current1 != null && current2 != null) {
                                        temp=false;

                  }
              }
                  if (current1 != null && current2 != null) {
               
                      if (current1.value>current2.value || current1.value == current2.value)
                      {
                     sum -= (current1.value - current2.value)*-1;
                     result.add(sum);
                      }
                      else if (current1.value<current2.value)
                      {
                           sum -= Math.abs(current1.value - current2.value);
                          sum+=10;
                          result.add(sum);
                          temp = true;
                          
                      }
            } else if (current1 != null) {
                      if (sum>0) {
                             sum += current1.value;
                result.add(sum);
                      }
                      else if(current1.value==0)
                      {
                          result.add(9);
                      }
                      else
                      {
                          sum += current1.value;
                result.add(sum);
                      }
             
            } else if (current2 != null) {
                sum += current2.value;
                result.add(sum);
            }
                  
                    if (current1 != null) {
                current1 = current1.next;

            }

            if (current2 != null) {
                current2 = current2.next;

            }
          }
                MybigInteger mb = new MybigInteger();
mb.itsNumber = result;
return mb;
    }

    

    @Override
    public MybigInteger multiply(MybigInteger second) {
        MybigInteger mb2 = new MybigInteger();
        MybigInteger mbi = new MybigInteger("0");
        MyLinkedList a = this.itsNumber;
        MyLinkedList b = second.itsNumber;
        MyLinkedList result = new MyLinkedList();
        Node current1 = a.first;
        Node current2 = b.first;
        int sum;
        int temp = 0;
        int basamak = 0;

        while (current2 != null) {

            sum = 0;
            sum += current1.value * current2.value;
            if (temp > 0) {
                sum += temp;
            }
            if (basamak >= 1 && current1 == a.first) {
                for (int i = 0; i < basamak; i++) {
                    result.add(0);

                }
            }
            result.add(sum % 10);
            temp = (int) Math.floor(sum / 10);

            if (current1.next == null) {
                current1 = a.first;
                current2 = current2.next;
                if (temp != 0) {
                    result.add(temp);
                }
                temp = 0;
                basamak++;

                Node n = result.first;
                MyLinkedList result2 = new MyLinkedList();
//ters cevirme
                while (n != null) {
                    result2.add(n.value);
                    result.first = n.next;
                    n = result.first;

                }

                mb2.itsNumber = result2;
                mbi = mbi.add(mb2);

                result = new MyLinkedList();

            } else {
                current1 = current1.next;

            }
        }
        return mbi;

    }

    @Override
    public MybigInteger exponent(MybigInteger second) {

        MybigInteger mbi = new MybigInteger("1");
        MybigInteger mbi2 = new MybigInteger("0");
        MybigInteger mbi3 = new MybigInteger("1");
        MyLinkedList b = second.itsNumber;
        Node currentforsum = b.first;
        String temp = new String();
        while (true) {
            mbi = mbi.multiply(this);
            mbi2 = mbi2.add(mbi3);

            while (currentforsum != null) {

                temp += currentforsum.value;

                currentforsum = currentforsum.next;

            }
            if (mbi2.toString().equals(temp)) {
                break;
            }

        }

        return mbi;

    }

}

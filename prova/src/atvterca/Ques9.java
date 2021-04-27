package atvterca;

import java.util.Arrays;

public class Ques9 {
    String[] pupulacao = {"10101110","01001010","11101100","01100011","00110101","00100011","10011001","11011000"};

    double[] iqq = new double[8];  String[] Bina = new String[8]; int[] Ca = new int[8];
//para binario//
    public String Fbin(int num){
            byte bi = (byte) num;
            String v;
            if (bi < 0) {
                v = Integer.toBinaryString (bi);
                v = v.substring (v.length() - 8);
            } else {
                v = "0000000" + Integer.toBinaryString (bi);
                v = v.substring (v.length() - 8);
            }

            return v;
        }
//para dacimal//
        public int Fdec(String bin){
            int potencia = 0;
            int decimal = 0;
            for(int i = bin.length() - 1; i>=0; i--){
                decimal += Math.pow(2,potencia) * Character.getNumericValue(bin.charAt(i));
                potencia ++;
            }
            return decimal;
        }

        public double Calc(int x)
        { return x*2-12*x+16; }

        public String[] Selecionar(){
            int j=0;
            int top = 4;
            for(int i = 0; i< pupulacao.length; i++){
                int gen1 = Fdec(pupulacao[i]);
                double gen2 = Calc(gen1);
                iqq[i] = gen2;
            }

            Arrays.sort(iqq);

            for(int i = 0; i<4; i++){
                iqq[i] = 0.0;
            }

            for(int i = 0; i< pupulacao.length; i++){
                iqq[i] = iqq[top];
                top++;
                if(top>7){
                    break;
                }
            }

            for(int i = 4; i< pupulacao.length; i++){
                iqq[i] = 0.0;
            }

            for(int i =0; i<8; i++){
                int ale1 = Fdec(pupulacao[i]);
                double ale2 = Calc(ale1);
                if(iqq[j] == ale2){
                    Ca[j] = ale1;
                    j++;
                    i=0;
                }
                if(j==3){
                    for(int t = 0 ; t<8; t++){
                        ale1    = Fdec(pupulacao[t]);
                        ale2 = Calc(ale1);
                        if(iqq[3] == ale2){
                            Ca[3] = ale1;
                        }
                    }
                }
            }

            for(int i =0; i<4; i++){
                Bina[i] = Fbin(Ca[i]);
            }

            for(int i=0; i<8; i++){
                pupulacao[i] = Bina[i];
            }
            return pupulacao;
        }

        public String[] getpopulacao(){
            return pupulacao;
        }

        public String cruzamento(String x, String y){
            char[] pai1 = x.toCharArray();
            char[] pai2 = y.toCharArray();
            char[] filho = new char[8];

            for(int i = 0; i<2; i++){
                filho[i] = pai1[i];
            }
            for(int i = 2; i<6; i++){
                filho[i] = pai2[i];
            }
            for(int i = 6; i<8; i++){
                filho[i] = pai2[i];
            }
            return String.valueOf(filho);
        }

    }
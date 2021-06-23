import unittest
import read_input
import cal_para_values

class test_bms_stream_receiver(unittest.TestCase):

    def test_to_check_format(self):

        self.assertTrue(read_input.check_data_type({"temperature":0.0,"soc":62.903126,"charge_rate":0.045999337}) == 'data_is_correct' )

    def test_to_wrong_format(self):   
        
        self.assertTrue(read_input.check_data_type({"temperature":0.0,"soc":'abcd',"charge_rate":0.045999337}) == 'data_is_not_correct' )
        self.assertTrue(read_input.check_data_type({"temperature":0.0,"soc":62.903126,"charge_rate":'abcd'}) == 'data_is_not_correct' )
        self.assertTrue(read_input.check_data_type({"temperature":'abcd',"soc":62.903126,"charge_rate":0.9}) == 'data_is_not_correct' )





if __name__ == '__main__':
  unittest.main()
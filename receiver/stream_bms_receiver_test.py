import unittest
from cal_para_values import min_max_smavg
import read_input
import cal_para_values

class test_bms_stream_receiver(unittest.TestCase):

    def test_to_check_format(self):

        self.assertTrue(read_input.check_data_type({"temperature":0.0,"soc":62.903126,"charge_rate":0.045999337}) == 'data_is_correct' )

    def test_to_check_wrong_format(self):   
        
        self.assertTrue(read_input.check_data_type({"temperature":0.0,"soc":'abcd',"charge_rate":0.045999337}) == 'data_is_not_correct' )

        self.assertTrue(read_input.check_data_type({"temperature":0.0,"soc":62.903126,"charge_rate":'abcd'}) == 'data_is_not_correct' )

        self.assertTrue(read_input.check_data_type({"temperature":'abcd',"soc":62.903126,"charge_rate":0.9}) == 'data_is_not_correct' )

    def test_to_check_cal_values(self):

        self.assertTrue(cal_para_values.cal_values([0,1,2,3,6]) == { 'min' :0, 'max': 6, 'simple moving average':2.4})
        self.assertTrue(cal_para_values.cal_values([0,1,2,3]) == { 'min' :0, 'max': 3})

    def test_to_check_false_cal_values(self):
        self.assertFalse(cal_para_values.cal_values([0,1,2,3]) == { 'min' :0, 'max': 3, 'simple moving average':1.2})

        self.assertFalse(cal_para_values.cal_values([0,2,4,8]) == { 'min' :0, 'max': 4})

        self.assertFalse(cal_para_values.cal_values([0,1,5,3]) == { 'min' :1, 'max': 5})

        self.assertFalse(cal_para_values.cal_values([2,0.01,0.8232,0.2583,3]) == { 'min' :0.01, 'max': 3, 'simple moving average':1.2163} )

        self.assertFalse(cal_para_values.cal_values([0,0.01,0.132,0.583,3]) == { 'min' :0, 'max': 3, 'simple moving average':0.75} )

    def test_to_check_min_max_smavg_output(self):
        self.assertTrue(cal_para_values.min_max_smavg([0,1,2,3],[0,2,4,4],[0,1,0.1,0.3]) == { 'temperature' :{ 'min' :0, 'max': 3},'soc':{ 'min' :0, 'max': 4},'chargeRate':{ 'min' :0, 'max': 1}})

        self.assertTrue(cal_para_values.min_max_smavg([0,2.1,2.5,3.8,1.89],[0,2,4,4,1],[0,1,0.1,0.3,1]) == {'temperature': {'min': 0, 'max': 3.8, 'simple moving average': 2.058},
                                                                                                             'soc': {'min': 0, 'max': 4, 'simple moving average': 2.2},
                                                                                                             'chargeRate': {'min': 0, 'max': 1, 'simple moving average': 0.48}})

        self.assertTrue(cal_para_values.min_max_smavg([0,1,8,5],[0,3,4.8,4],[0,1,0.1,0.3]) == { 'temperature' :{ 'max': 8, 'min' :0 },'chargeRate':{ 'min' :0, 'max': 1} ,'soc':{ 'min' :0, 'max': 4.8}})

        self.assertTrue(cal_para_values.min_max_smavg([0,1,2,3,1],[0,2,4,4,1],[0,1,0.1,0.3,1]) == { 'temperature' :{ 'min' :0, 'max': 3, 'simple moving average':1.4},
                                                                                                   'chargeRate':{ 'min' :0, 'max': 1, 'simple moving average':0.48},
                                                                                                   'soc':{ 'min' :0, 'max': 4, 'simple moving average':2.2000}})


if __name__ == '__main__':
  unittest.main()

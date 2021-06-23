import read_input
import cal_para_values 
from cal_para_values  import temperature_lst , chargeRate_lst, soc_lst

if __name__ == '__main__':

    while True:
        temperature,soc,chargeRate, validate_data = read_input.read_sender_input()
        if temperature == None or chargeRate == None or soc == None  :
            break
        elif validate_data == 'data_is_not_correct' :
            break
        cal_para_values.get_para_list(temperature,soc,chargeRate)
        cal_parameters = cal_para_values.min_max_smavg(temperature_lst, chargeRate_lst, soc_lst)
        cal_para_values.print_to_consol(cal_parameters)
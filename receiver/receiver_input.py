import json
def read_sender_input():
    try:
        input_data = input()
        data_dict = json.loads(input_data)
        return get_values(data_dict)             
    except EOFError:
        return None, None, None

def get_values(data_dict):
    temperature = data_dict['temperature']
    soc = data_dict['soc']
    chargeRate = data_dict['charge_rate']
    return temperature, soc, chargeRate

temperature_lst = []
chargeRate_lst = []
soc_lst = []

def get_para_list(para1, para2, para3):
    temperature_lst.append(para1)
    chargeRate_lst.append(para2)
    soc_lst.append(para3)
    return temperature_lst, chargeRate_lst, soc_lst


def min_max_smavg(para1, para2, para3):
    para_values = {}
    para_values['temperature'] = cal_values(para1)
    para_values['soc'] = cal_values(para2)
    para_values['chargeRate'] = cal_values(para3)
    return para_values

def cal_values(parameter):
    parameter_values = {}
    parameter_values['min'] = min(parameter)
    parameter_values['max'] = max(parameter)
    if len(parameter)>= 5:
       parameter_values['smavg'] = sum(parameter[-5:])/5
    return parameter_values

def print_to_consol(para_values):
    for keys, values in para_values.items():
            print(f'{keys} : {para_values[keys]}')


if __name__ == '__main__':

    while True:
        temperature,soc,chargeRate = read_sender_input()
        if temperature == None or chargeRate == None or soc == None  :
            break
        get_para_list(temperature,soc,chargeRate)
        x = min_max_smavg(temperature_lst, chargeRate_lst, soc_lst)
        print_to_consol(x)

    
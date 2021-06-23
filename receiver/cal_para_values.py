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
       parameter_values['simple moving average'] = round(sum(parameter[-5:])/5,3)
    return parameter_values

def print_to_consol(para_values):
    for keys, values in para_values.items():
            print(f'{keys} : {para_values[keys]}')

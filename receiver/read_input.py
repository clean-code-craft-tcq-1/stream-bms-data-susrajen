import json
def read_sender_input():
    try:
        input_data = input()
        data_dict = json.loads(input_data)
        return get_values(data_dict)             
    except EOFError:
        return None, None, None, None

def get_values(data_dict):
    temperature = data_dict['temperature']
    soc = data_dict['soc']
    chargeRate = data_dict['chargeRate'] 
    validate_data = check_data_type(data_dict)
    return temperature, soc, chargeRate , validate_data

def check_data_type(data_dict):
    count = 0
    for k, v in data_dict.items():
        if type(v) == int or type(v) == float :
            count = count +1
    if count ==3:
        return "data_is_correct"
    else:
        return "data_is_not_correct"

package com.demo.study.wallet.usdt;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes1;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class ContractAbi extends Contract {
    public static final String BINARY = "0x608060405234801561000f575f80fd5b50600436106100e5575f3560e01c806370a082311161008857806395d89b411161006357806395d89b41146101d1578063a9059cbb146101d9578063d505accf146101ec578063dd62ed3e146101ff575f80fd5b806370a082311461017b5780637ecebe00146101a357806384b0196e146101b6575f80fd5b806323b872dd116100c357806323b872dd1461013c578063313ce5671461014f5780633644e5151461015e57806340c10f1914610166575f80fd5b806306fdde03146100e9578063095ea7b31461010757806318160ddd1461012a575b5f80fd5b6100f1610237565b6040516100fe9190610c96565b60405180910390f35b61011a610115366004610cca565b6102c7565b60405190151581526020016100fe565b6002545b6040519081526020016100fe565b61011a61014a366004610cf2565b6102e0565b604051601281526020016100fe565b61012e610303565b610179610174366004610cca565b610311565b005b61012e610189366004610d2b565b6001600160a01b03165f9081526020819052604090205490565b61012e6101b1366004610d2b565b61031f565b6101be61033c565b6040516100fe9796959493929190610d44565b6100f161037e565b61011a6101e7366004610cca565b61038d565b6101796101fa366004610ddb565b61039a565b61012e61020d366004610e48565b6001600160a01b039182165f90815260016020908152604080832093909416825291909152205490565b60606003805461024690610e79565b80601f016020809104026020016040519081016040528092919081815260200182805461027290610e79565b80156102bd5780601f10610294576101008083540402835291602001916102bd565b820191905f5260205f20905b8154815290600101906020018083116102a057829003601f168201915b5050505050905090565b5f336102d48185856104d5565b60019150505b92915050565b5f336102ed8582856104e7565b6102f8858585610562565b506001949350505050565b5f61030c6105bf565b905090565b61031b82826106e8565b5050565b6001600160a01b0381165f908152600760205260408120546102da565b5f6060805f805f606061034d61071c565b610355610749565b604080515f80825260208201909252600f60f81b9b939a50919850469750309650945092509050565b60606004805461024690610e79565b5f336102d4818585610562565b834211156103c35760405163313c898160e11b8152600481018590526024015b60405180910390fd5b5f7f6e71edae12b1b97f4d1f60370fef10105fa2faae0126114a169c64845d6126c988888861040e8c6001600160a01b03165f90815260076020526040902080546001810190915590565b6040805160208101969096526001600160a01b0394851690860152929091166060840152608083015260a082015260c0810186905260e0016040516020818303038152906040528051906020012090505f61046882610776565b90505f610477828787876107a2565b9050896001600160a01b0316816001600160a01b0316146104be576040516325c0072360e11b81526001600160a01b0380831660048301528b1660248201526044016103ba565b6104c98a8a8a6104d5565b50505050505050505050565b6104e283838360016107ce565b505050565b6001600160a01b038381165f908152600160209081526040808320938616835292905220545f19811461055c578181101561054e57604051637dc7a0d960e11b81526001600160a01b038416600482015260248101829052604481018390526064016103ba565b61055c84848484035f6107ce565b50505050565b6001600160a01b03831661058b57604051634b637e8f60e11b81525f60048201526024016103ba565b6001600160a01b0382166105b45760405163ec442f0560e01b81525f60048201526024016103ba565b6104e28383836108a0565b5f306001600160a01b037f000000000000000000000000f4bb9f6634b7228ede7f0252771015ca193853fa1614801561061757507f0000000000000000000000000000000000000000000000000000000000aa36a746145b1561064157507fe6c873e8a224eefc01bd643d081f4e905b9cf4a22ee02a0c647efadf8a5ea23f90565b61030c604080517f8b73c3c69bb8fe3d512ecc4cf759cc79239f7b179b0ffacaa9a75d522b39400f60208201527f7e566ba522c244d5505802d09c34d95268802ec3ccf066d308dbafa9bc6ff7fd918101919091527fc89efdaa54c0f20c7adf612882df0950f5a951637e0307cdcb4c672f298b8bc660608201524660808201523060a08201525f9060c00160405160208183030381529060405280519060200120905090565b6001600160a01b0382166107115760405163ec442f0560e01b81525f60048201526024016103ba565b61031b5f83836108a0565b606061030c7f546573742055534454000000000000000000000000000000000000000000000960056109c6565b606061030c7f310000000000000000000000000000000000000000000000000000000000000160066109c6565b5f6102da6107826105bf565b8360405161190160f01b8152600281019290925260228201526042902090565b5f805f806107b288888888610a6f565b9250925092506107c28282610b37565b50909695505050505050565b6001600160a01b0384166107f75760405163e602df0560e01b81525f60048201526024016103ba565b6001600160a01b03831661082057604051634a1406b160e11b81525f60048201526024016103ba565b6001600160a01b038085165f908152600160209081526040808320938716835292905220829055801561055c57826001600160a01b0316846001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9258460405161089291815260200190565b60405180910390a350505050565b6001600160a01b0383166108ca578060025f8282546108bf9190610eb1565b9091555061093a9050565b6001600160a01b0383165f908152602081905260409020548181101561091c5760405163391434e360e21b81526001600160a01b038516600482015260248101829052604481018390526064016103ba565b6001600160a01b0384165f9081526020819052604090209082900390555b6001600160a01b03821661095657600280548290039055610974565b6001600160a01b0382165f9081526020819052604090208054820190555b816001600160a01b0316836001600160a01b03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040516109b991815260200190565b60405180910390a3505050565b606060ff83146109e0576109d983610bef565b90506102da565b8180546109ec90610e79565b80601f0160208091040260200160405190810160405280929190818152602001828054610a1890610e79565b8015610a635780601f10610a3a57610100808354040283529160200191610a63565b820191905f5260205f20905b815481529060010190602001808311610a4657829003601f168201915b505050505090506102da565b5f80807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a0841115610aa857505f91506003905082610b2d565b604080515f808252602082018084528a905260ff891692820192909252606081018790526080810186905260019060a0016020604051602081039080840390855afa158015610af9573d5f803e3d5ffd5b5050604051601f1901519150506001600160a01b038116610b2457505f925060019150829050610b2d565b92505f91508190505b9450945094915050565b5f826003811115610b4a57610b4a610ed0565b03610b53575050565b6001826003811115610b6757610b67610ed0565b03610b855760405163f645eedf60e01b815260040160405180910390fd5b6002826003811115610b9957610b99610ed0565b03610bba5760405163fce698f760e01b8152600481018290526024016103ba565b6003826003811115610bce57610bce610ed0565b0361031b576040516335e2f38360e21b8152600481018290526024016103ba565b60605f610bfb83610c2c565b6040805160208082528183019092529192505f91906020820181803683375050509182525060208101929092525090565b5f60ff8216601f8111156102da57604051632cd44ac360e21b815260040160405180910390fd5b5f81518084525f5b81811015610c7757602081850181015186830182015201610c5b565b505f602082860101526020601f19601f83011685010191505092915050565b602081525f610ca86020830184610c53565b9392505050565b80356001600160a01b0381168114610cc5575f80fd5b919050565b5f8060408385031215610cdb575f80fd5b610ce483610caf565b946020939093013593505050565b5f805f60608486031215610d04575f80fd5b610d0d84610caf565b9250610d1b60208501610caf565b9150604084013590509250925092565b5f60208284031215610d3b575f80fd5b610ca882610caf565b60ff60f81b881681525f602060e06020840152610d6460e084018a610c53565b8381036040850152610d76818a610c53565b606085018990526001600160a01b038816608086015260a0850187905284810360c0860152855180825260208088019350909101905f5b81811015610dc957835183529284019291840191600101610dad565b50909c9b505050505050505050505050565b5f805f805f805f60e0888a031215610df1575f80fd5b610dfa88610caf565b9650610e0860208901610caf565b95506040880135945060608801359350608088013560ff81168114610e2b575f80fd5b9699959850939692959460a0840135945060c09093013592915050565b5f8060408385031215610e59575f80fd5b610e6283610caf565b9150610e7060208401610caf565b90509250929050565b600181811c90821680610e8d57607f821691505b602082108103610eab57634e487b7160e01b5f52602260045260245ffd5b50919050565b808201808211156102da57634e487b7160e01b5f52601160045260245ffd5b634e487b7160e01b5f52602160045260245ffdfea2646970667358221220d688ffe255978ee1a47eba788e5709231d58512e2ee50155971b0384ce22851664736f6c63430008160033";

    public static final String FUNC_DOMAIN_SEPARATOR = "DOMAIN_SEPARATOR";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_EIP712DOMAIN = "eip712Domain";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_NONCES = "nonces";

    public static final String FUNC_PERMIT = "permit";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event EIP712DOMAINCHANGED_EVENT = new Event("EIP712DomainChanged", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ContractAbi(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ContractAbi(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ContractAbi(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ContractAbi(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<EIP712DomainChangedEventResponse> getEIP712DomainChangedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(EIP712DOMAINCHANGED_EVENT, transactionReceipt);
        ArrayList<EIP712DomainChangedEventResponse> responses = new ArrayList<EIP712DomainChangedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            EIP712DomainChangedEventResponse typedResponse = new EIP712DomainChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EIP712DomainChangedEventResponse> eIP712DomainChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EIP712DomainChangedEventResponse>() {
            @Override
            public EIP712DomainChangedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(EIP712DOMAINCHANGED_EVENT, log);
                EIP712DomainChangedEventResponse typedResponse = new EIP712DomainChangedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<EIP712DomainChangedEventResponse> eIP712DomainChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EIP712DOMAINCHANGED_EVENT));
        return eIP712DomainChangedEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> DOMAIN_SEPARATOR() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DOMAIN_SEPARATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>> eip712Domain() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EIP712DOMAIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes1>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>>(function,
                new Callable<Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>>() {
                    @Override
                    public Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<byte[], String, String, BigInteger, String, byte[], List<BigInteger>>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (byte[]) results.get(5).getValue(), 
                                convertToNative((List<Uint256>) results.get(6).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String to, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> nonces(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NONCES, 
                Arrays.<Type>asList(new Address(160, owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> permit(String owner, String spender, BigInteger value, BigInteger deadline, BigInteger v, byte[] r, byte[] s) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PERMIT, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, spender),
                new Uint256(value),
                new Uint256(deadline),
                new Uint8(v),
                new Bytes32(r),
                new Bytes32(s)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String to, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new Address(160, to),
                new Uint256(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(160, from),
                new Address(160, to),
                new Uint256(value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ContractAbi load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContractAbi(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ContractAbi load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContractAbi(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ContractAbi load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ContractAbi(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContractAbi load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ContractAbi(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContractAbi> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContractAbi.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ContractAbi> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContractAbi.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContractAbi> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContractAbi.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContractAbi> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContractAbi.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class EIP712DomainChangedEventResponse extends BaseEventResponse {
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
